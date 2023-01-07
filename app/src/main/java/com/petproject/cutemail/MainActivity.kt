package com.petproject.cutemail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Not using findNavController here because it can fail
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //Setting up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.material_toolbar)
        setSupportActionBar(toolbar)

        //Setting the title in toolbar when navigating
        val appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
        toolbar.setupWithNavController(navController, appBarConfiguration)

        //Setting up bottom navigation
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }
}