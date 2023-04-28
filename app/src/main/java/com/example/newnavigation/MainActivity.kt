package com.example.newnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newnavigation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.DrawerLayout)
        navigationView = findViewById(R.id.NavigationView)

        navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.aboutFragment,R.id.serviceFragment))
        setupActionBarWithNavController(navController, drawerLayout)
        navigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration)   || super.onSupportNavigateUp()
    }

}