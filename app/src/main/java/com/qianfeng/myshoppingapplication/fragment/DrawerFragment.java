package com.qianfeng.myshoppingapplication.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.qianfeng.myshoppingapplication.MainActivity;
import com.qianfeng.myshoppingapplication.R;
import com.qianfeng.myshoppingapplication.contants.Contants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DrawerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DrawerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrawerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView drawRecyclerView;
    private LinearLayout todayTab;
    private LinearLayout valueTab;
    private LinearLayout walkTab;
    private LinearLayout morningTab;
    private FragmentManager fragmentManager;
    //定义四个碎片
    private TodayFragment todayFragment;
    private ValueFragment valueFragment;
    private WalkFragment walkFragment;
    private MorningFragment morningFragment;
    private Button vaButton;
    private Button testBtn;
    private Context mContext;

    public DrawerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrawerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrawerFragment newInstance(String param1, String param2) {
        DrawerFragment fragment = new DrawerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_drawer, container, false);
        todayTab = ((LinearLayout) view.findViewById(R.id.today));
        valueTab = ((LinearLayout) view.findViewById(R.id.value));
        walkTab = ((LinearLayout) view.findViewById(R.id.walk));
        morningTab = ((LinearLayout) view.findViewById(R.id.morning));

        //获取fragment管理器
        fragmentManager = getFragmentManager();
        todayTab.setSelected(true);

        todayTab.setOnClickListener(this);
        valueTab.setOnClickListener(this);
        walkTab.setOnClickListener(this);
        morningTab.setOnClickListener(this);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        Log.e("BBBB1", "onClick: 0000" );
        switch (v.getId()){
            case R.id.today:
                Log.e("BBBB", "onClick: 0000" );
                todayTab.setSelected(true);
                valueTab.setSelected(false);
                walkTab.setSelected(false);
                morningTab.setSelected(false);
                OnTabSelectedChangeFragment(Contants.TODAY_FRAGMENT);
                break;
            case R.id.value:
                Log.e("BBBB", "onClick: aaaa" );
                todayTab.setSelected(false);
                valueTab.setSelected(true);
                walkTab.setSelected(false);
                morningTab.setSelected(false);
                OnTabSelectedChangeFragment(Contants.VALUE_FRAGMENT);
                break;

            case R.id.walk:
                Log.e("BBBB", "onClick: bbbb" );
                todayTab.setSelected(false);
                valueTab.setSelected(false);
                walkTab.setSelected(true);
                morningTab.setSelected(false);
                OnTabSelectedChangeFragment(Contants.WALK_FRAGMENT);
                break;

            case R.id.morning:
                Log.e("BBBB", "onClick: cccc" );
                todayTab.setSelected(false);
                valueTab.setSelected(false);
                walkTab.setSelected(false);
                morningTab.setSelected(true);
                OnTabSelectedChangeFragment(Contants.MORNING_FRAGMENT);
                break;

        }


    }

    private void OnTabSelectedChangeFragment(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case Contants.TODAY_FRAGMENT:
                if(todayFragment ==null){
                    todayFragment =new TodayFragment();
                    transaction.add(R.id.containerID,todayFragment);
                }else {
                    transaction.show(todayFragment);
                }
                break;

            case Contants.VALUE_FRAGMENT:
                if(valueFragment ==null){
                    valueFragment =new ValueFragment();
                    transaction.add(R.id.containerID,valueFragment);
                }else {
                    transaction.show(valueFragment);
                }
                break;

            case Contants.WALK_FRAGMENT:
                if(walkFragment ==null){
                    walkFragment=new WalkFragment();
                    transaction.add(R.id.containerID,walkFragment);
                }else {
                    transaction.show(walkFragment);
                }
                break;

            case Contants.MORNING_FRAGMENT:
                if(morningFragment ==null){
                    morningFragment =new MorningFragment();
                    transaction.add(R.id.containerID,morningFragment);
                }else {
                    transaction.show(morningFragment);
                }
                break;
        }

        transaction.commit();

    }

    private void hideFragments(FragmentTransaction transaction) {
        if(todayFragment !=null){
            transaction.hide(todayFragment);
        }

        if(valueFragment !=null){
            transaction.hide(valueFragment);
        }

        if(walkFragment !=null){
            transaction.hide(walkFragment);
        }

        if(morningFragment !=null){
            transaction.hide(morningFragment);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
