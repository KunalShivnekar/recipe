package com.kunal.recipe.view.step

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kunal.recipe.R
import com.kunal.recipe.model.Step
import com.kunal.recipe.view.base.BaseFragment
import kotlinx.android.synthetic.main.step_fragment.view.description
import kotlinx.android.synthetic.main.step_fragment.view.shortDescription
import kotlinx.android.synthetic.main.step_fragment.view.video

private const val ARG_STEP = "ARG_STEP"

class StepFragment : BaseFragment() {

    private lateinit var viewModel: StepViewModel

    private val step: Step by lazy { requireNotNull(arguments).getParcelable(ARG_STEP) as Step }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.step_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            if (step.videoURL.isNotEmpty()) {
                video.visibility = View.VISIBLE
                video.setVideoPath(step.videoURL)
                video.start()
            }
            shortDescription.text = step.shortDescription
            description.text = step.description
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StepViewModel::class.java)
        attachObserver(viewModel)
    }

    companion object {
        fun newInstance(step: Step) = StepFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_STEP, step)
            }
        }
    }
}
