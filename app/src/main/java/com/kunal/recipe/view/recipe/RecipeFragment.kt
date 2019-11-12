package com.kunal.recipe.view.recipe

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kunal.recipe.R
import com.kunal.recipe.data.base.Response
import com.kunal.recipe.model.Recipe
import com.kunal.recipe.view.base.BaseFragment

class RecipeFragment : BaseFragment(), RecipeAdapter.OnRecipeSelectedListener {

    companion object {
        fun newInstance() = RecipeFragment()
    }

    private lateinit var viewModel: RecipeViewModel

    private val recipeAdapter = RecipeAdapter(this)

    private var listener: OnRecipeInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.recipe_fragment, container, false) as RecyclerView
        val columns = resources.getInteger(R.integer.recipe_column)
        with(view) {
            layoutManager = if (columns == 1)
                LinearLayoutManager(context)
            else
                GridLayoutManager(context, columns)
            adapter = recipeAdapter
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        showLoader()
        viewModel.getRecipe().observe(this, Observer<List<Recipe>> {
            it?.let {
                hideLoader()
                recipeAdapter.submitList(it)
            }
        })

        viewModel.getError().observe(this, Observer<Response> {
            it?.let {
                hideLoader()
                showError(it.description)

            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        if (context is OnRecipeInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnScansInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RecipeViewModel::class.java)
        attachObserver(viewModel)
    }

    override fun onRecipeSelected(recipe: Recipe) {
        listener?.showRecipe(recipe)
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    interface OnRecipeInteractionListener {
        fun showRecipe(recipe: Recipe)
    }
}
