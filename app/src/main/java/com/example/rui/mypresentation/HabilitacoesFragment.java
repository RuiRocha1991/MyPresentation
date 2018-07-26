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
import android.view.animation.ScaleAnimation;


/**
 * A simple {@link Fragment} subclass.
 */
public class HabilitacoesFragment extends Fragment {
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    public HabilitacoesFragment() {
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
        View view=inflater.inflate(R.layout.fragment_habilitacoes, container, false);
        View contenedor = (View)container.getParent();
        appBar=(AppBarLayout)contenedor.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);
        viewPager= (ViewPager)view.findViewById(R.id.pagerHab);
        ViewPagerAdapterHab pagerAdapter= new ViewPagerAdapterHab(getFragmentManager());
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
    public class ViewPagerAdapterHab extends FragmentStatePagerAdapter {
        public ViewPagerAdapterHab(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        String[] titulosTabs= {"2016/Presente","2006/2009", "2006" };


        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new HabTab1Fragment();
                case 1: return new HabTab2Fragment();
                case 2: return new HabTab3Fragment();
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
