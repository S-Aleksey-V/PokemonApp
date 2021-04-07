package me.tolkstudio.pokemonapp.ui.activity


import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import me.tolkstudio.pokemonapp.R
import me.tolkstudio.pokemonapp.databinding.ActivityMainBinding
import me.tolkstudio.pokemonapp.mvp.presenter.MainPresenter
import me.tolkstudio.pokemonapp.mvp.view.MainView
import me.tolkstudio.pokemonapp.ui.App
import me.tolkstudio.pokemonapp.ui.BackButtonListener
import me.tolkstudio.pokemonapp.ui.navigation.AndroidScreens
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }
    private var vb: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()


    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }
}