package com.example.rui.mypresentation;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        HomeFragment homeFragment=new HomeFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.repositorio, homeFragment, homeFragment.getTag()).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            this.openGmail(null);
        }else if (id== R.id.contactar){

            this.openContactos(null);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.support.v4.app.FragmentManager manager= getSupportFragmentManager();
        if (id == R.id.nav_sobreMim) {
            Toast.makeText(this, "Sobre Mim", Toast.LENGTH_SHORT).show();
            SobreMimFragment sobreMimFragment = new SobreMimFragment();
            manager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out ).replace(R.id.repositorio, sobreMimFragment, sobreMimFragment.getTag()).commit();

        } else if (id == R.id.nav_habilitacoes) {
            Toast.makeText(this, "Habilitações Académicas", Toast.LENGTH_SHORT).show();
            HabilitacoesFragment habilitacoesFragment = new HabilitacoesFragment();
            manager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out ).replace(R.id.repositorio,habilitacoesFragment, habilitacoesFragment.getTag()).commit();

        } else if (id == R.id.nav_experiencia) {
            Toast.makeText(this, "Experiência Profissional", Toast.LENGTH_SHORT).show();
            ExperienciaFragment experienciaFragment= new ExperienciaFragment();
            manager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out ).replace(R.id.repositorio,experienciaFragment,experienciaFragment.getTag()).commit();

        } else if (id == R.id.nav_skills) {
            Toast.makeText(this, "Skills", Toast.LENGTH_SHORT).show();
            SkillsFragment skillsFragment= new SkillsFragment();
            manager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out ).replace(R.id.repositorio, skillsFragment,skillsFragment.getTag()).commit();

        } else if (id == R.id.nav_conferencias) {
            Toast.makeText(this, "Participação Conferências", Toast.LENGTH_SHORT).show();
            ConferenciasFragment conferenciasFragment = new ConferenciasFragment();
            manager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out ).replace(R.id.repositorio, conferenciasFragment, conferenciasFragment.getTag()).commit();

        } else if (id == R.id.nav_hobbies) {
            Toast.makeText(this, "Hobbies", Toast.LENGTH_SHORT).show();
            HobbiesFragment hobbiesFragment = new HobbiesFragment();
            manager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out ).replace(R.id.repositorio, hobbiesFragment, hobbiesFragment.getTag()).commit();

        }else if(id==R.id.nav_terminar){
            Toast.makeText(this, "Terminar", Toast.LENGTH_SHORT).show();
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Função para carregar o ecra inicial sempre que pressionar a foto do menuDrawer
     * @param view
     */
    public void carregaHome(View view){
        Toast.makeText(this, "Home ", Toast.LENGTH_SHORT).show();
        HomeFragment homeFragment=new HomeFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out ).replace(R.id.repositorio, homeFragment, homeFragment.getTag()).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    /**
     * Funçao para iniciar o email envia o email destino e um assundo pre-definido
     * @param view
     */
    public void openGmail(View view) {
        Toast.makeText(this, "Abrir Email", Toast.LENGTH_SHORT).show();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        String[] recipients={"rocharui@ipvc.pt"};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contacto Para Entrevista");
        emailIntent.setType("text/plain");
        final PackageManager pm = getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(emailIntent, 0);
        ResolveInfo best = null;
        for(final ResolveInfo info : matches)
            if (info.activityInfo.packageName.endsWith(".gm") || info.activityInfo.name.toLowerCase().contains("gmail"))
                best = info;
        if (best != null)
            emailIntent.setClassName(best.activityInfo.packageName, best.activityInfo.name);

        startActivity(emailIntent);
    }

    /**
     * Função que vai ativar o serviço de chamadas telefonicas e coloca o meu contacto pronto a contactar
     * @param view
     */
    public void openContactos(View view) {
        Toast.makeText(this, "Contactar ", Toast.LENGTH_SHORT).show();
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:913268579"));

        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

}
