package com.kunal.recipe.view.details

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.kunal.recipe.R
import com.kunal.recipe.model.Ingredient
import com.kunal.recipe.model.Recipe
import com.kunal.recipe.model.Step
import com.kunal.recipe.view.base.BaseFragment
import kotlinx.android.synthetic.main.recipe_details_fragment.view.ingredients
import kotlinx.android.synthetic.main.recipe_details_fragment.view.stepsList

private const val ARG_RECIPE = "ARG_RECIPE"

class RecipeDetailsFragment : BaseFragment(), RecipeStepsAdapter.OnRecipeStepSelectedListener {

    private lateinit var viewModel: RecipeDetailsViewModel

    private val recipeStepsAdapter = RecipeStepsAdapter(this)

    private var listener: OnRecipeDetailsInteractionListener? = null

    val recipe: Recipe by lazy { requireNotNull(arguments).getParcelable(ARG_RECIPE) as Recipe }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recipe_details_fragment, container, false)
        with(view.stepsList) {
            adapter = recipeStepsAdapter
            layoutManager = LinearLayoutManager(context)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.ingredients.setOnClickListener { listener?.showRecipeIngredients(recipe.ingredients) }
        recipeStepsAdapter.contentList = recipe.steps
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipeDetailsViewModel::class.java)
        attachObserver(viewModel)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnRecipeDetailsInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnScansInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onRecipeStepSelected(step: Step) {
        listener?.showRecipeStep(step)
    }

    companion object {
        fun newInstance(recipe: Recipe) = RecipeDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_RECIPE, recipe)
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    interface OnRecipeDetailsInteractionListener {
        fun showRecipeStep(step: Step)

        fun showRecipeIngredients(ingredients: List<Ingredient>)
    }
}
