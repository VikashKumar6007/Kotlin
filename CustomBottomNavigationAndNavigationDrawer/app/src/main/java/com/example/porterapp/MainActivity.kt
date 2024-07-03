package com.example.porterapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.porterapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this,binding.DrawerLayout,binding.toolbar,R.string.nav_open,R.string.nav_close)
        binding.DrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.naviagtionDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background= null

        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.home -> openFragment(HomeFragment())
                R.id.cart -> openFragment(CartFragment())
                R.id.favorites -> openFragment(FavouritFragment())
                R.id.Account -> openFragment(ProfileFragment())

            }
            true
        }

        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.nav_prime -> openFragment(HomeFragment())
//        }
//      //  binding.DrawerLayout.closeDrawers(GravityCompat.START)
//        return true
//    }

    override fun onBackPressed() {
        if (binding.DrawerLayout.isDrawerOpen(GravityCompat.START)){
        }else{
            super.onBackPressed()
        }
    }


    private fun openFragment(fragment: Fragment){
        val fragmentTransaction :FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_Container,fragment)
        fragmentTransaction.commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_prime -> openFragment(HomeFragment())
        }
      //  binding.DrawerLayout.closeDrawers(GravityCompat.START)
        return true
    }
}