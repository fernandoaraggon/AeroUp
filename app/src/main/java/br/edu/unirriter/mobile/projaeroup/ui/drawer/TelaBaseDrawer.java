package br.edu.unirriter.mobile.projaeroup.ui.drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.ui.TelaAgenda;
import br.edu.unirriter.mobile.projaeroup.ui.TelaHome;
import br.edu.unirriter.mobile.projaeroup.ui.TelaLogin;
import br.edu.unirriter.mobile.projaeroup.utils.PreferenciaComp;

public class TelaBaseDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_tela_base_drawer, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView =drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_drawer_aberto,R.string.menu_drawer_fechado);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.nav_home:
                startActivity(new Intent(this, TelaHome.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_agenda:
                startActivity(new Intent(this, TelaAgenda.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_logout:
                startActivity(new Intent(this, TelaLogin.class));
                overridePendingTransition(0,0);
                PreferenciaComp prefComp = new PreferenciaComp(this);
                prefComp.limpar();
                break;
        }
        return false;
    }

    protected void allocateAcitivityTitle(String titleString)
    {
        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(titleString);
        }
    }
}