package com.uneatlantico.uneapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_inicio.*


class InicioActivity : AppCompatActivity() {
    //var fragment: Fragment? = null
    private var inicioFragment = InicioFragment.newInstance()
    private var campusFragment = CampusFragment.newInstance()
    private var qrScannerFragment = QrScannerFragment.newInstance()
    private var horarioFragment = HorarioFragment.newInstance()
    private val fm = supportFragmentManager
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var nvDrawer: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        openFragment(inicioFragment)

        //https://github.com/codepath/android_guides/wiki/Fragment-Navigation-Drawer
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        mDrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        nvDrawer = findViewById<NavigationView>(R.id.nvView)
        setupDrawerContent(nvDrawer)

        //All sobre la barra de navegacion inferior
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        BottomNavigationViewComplements.removeShiftMode(bottomNavigationView)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener(

                    fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                        selectDrawerItem(menuItem)
                        return true
                    }
                )
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item ->
        when (item.itemId) {

            R.id.navigation_home -> {
                inicioFragment = InicioFragment.newInstance()
                openFragment(inicioFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_campus -> {

                //campusFragment = CampusFragment.newInstance()
                openFragment(campusFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_qr -> {
                qrScannerFragment = QrScannerFragment.newInstance()
                openFragment(qrScannerFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_horario -> {
                horarioFragment = HorarioFragment.newInstance()
                openFragment(horarioFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /**
     * ABRE UN NUEVO FRAGMENTO ENCIMA DEL ANTERIOR
     */
    private fun openFragment(fragment: Fragment) {
        val transaction = fm.beginTransaction()
        //hideAllFragments()
        transaction.replace(R.id.container, fragment)

        transaction.addToBackStack(null)

        transaction.commit()
    }
    private fun hideAllFragments(){
        val transaction2 = fm.beginTransaction()
        transaction2.hide(inicioFragment)
        transaction2.hide(campusFragment)
        transaction2.hide(qrScannerFragment)
        transaction2.hide(horarioFragment)
        transaction2.commit()
    }

    /**
     * estaba en oncreate xd
     */
    /*fragment = fm.findFragmentByTag("inicioFragment")

        if (fragment == null) {
            val ft = fm.beginTransaction()
            fragment = InicioFragment()
            ft.add(android.R.id.content, fragment, "inicioFragment")
            ft.commit()

        }*/
    /*val viewPager = findViewById<ViewPager>(R.id.viewpager)

    // Create an adapter that knows which fragment should be shown on each page
    val adapter = InicioPagerAdapter(this, supportFragmentManager)

    // Set the adapter onto the view pager
    viewPager.adapter = adapter

    // Give the TabLayout the ViewPager
    val tabLayout = findViewById<TabLayout>(R.id.sliding_tabs)
    tabLayout.setupWithViewPager(viewPager)*/
}
