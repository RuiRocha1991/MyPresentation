package com.example.rui.mypresentation;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienciaFragment extends Fragment {
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    public ExperienciaFragment() {
        // Required empty public constructor
    }

    /**
     * Função que vai conter os 3 tabs criados e os vai alternar
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View que vai ser apresentada
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_experiencia, container, false);
        View contenedor = (View)container.getParent();
        appBar=(AppBarLayout)contenedor.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);
        viewPager= (ViewPager)view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter= new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        appBar.removeView(tabs);
    }

    /**
     * Classe criada para adaptar o ViewPager, isto para conseguir utilizar os fragments com tabs incluidas.
     */
    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        String[] titulosTabs= {"Mephisto Portugal","DivIbérica", "Fontes&Fontes" };


        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new ExpTab1Fragment();
                case 1: return new ExpTab2Fragment();
                case 2: return new ExpTab3Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulosTabs[position];
        }
    }

}
