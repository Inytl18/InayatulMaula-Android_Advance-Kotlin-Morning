package com.inayatulmaula.applicationmobile

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.inayatulmaula.applicationmobile.databinding.ActivityMainBinding
import com.inayatulmaula.applicationmobile.ui.dashboard.DashboardFragment
import com.inayatulmaula.applicationmobile.ui.home.HomeFragment
import com.inayatulmaula.applicationmobile.ui.menu.MenuFragment
import com.inayatulmaula.applicationmobile.ui.navDrawer.FoodsFragment
import com.inayatulmaula.applicationmobile.ui.navDrawer.ShopFragment
import com.inayatulmaula.applicationmobile.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,
            R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navDrawer.setNavigationItemSelectedListener ( this)
        binding.bottomNav.background = null
        binding.bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> openFragment(HomeFragment())
                R.id.navigation_dashboard -> openFragment(DashboardFragment())
                R.id.navigation_notifications -> openFragment(NotificationsFragment())
                R.id.nav_menu -> openFragment(MenuFragment())
            }
            true
        }

        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())

        binding.fab.setOnClickListener{
            Toast.makeText(this, "Categories", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_food -> openFragment(FoodsFragment())
            R.id.nav_shop -> openFragment(ShopFragment())
            R.id.nav_setting -> Toast.makeText(this,"Kamu Menekan Setting", Toast.LENGTH_LONG).show()
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressedDispatcher.onBackPressed()
        }
    }
    private fun openFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.tbAddcontact -> Toast.makeText(this,"Kamu Menekan Add COntact", Toast.LENGTH_LONG).show()
            R.id.tbFavorite -> Toast.makeText(this,"Kamu Menekan Favorite", Toast.LENGTH_LONG).show()
            R.id.tbSetting -> Toast.makeText(this,"Kamu Menekan Setting", Toast.LENGTH_LONG).show()
            R.id.tbClose -> finish()

        }
        return true
    }
}