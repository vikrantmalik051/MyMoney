package com.example.mymoney;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frag_home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frag_home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag_home extends Fragment {


    public void updatetv(){
        if(getActivity()!= null) {
            DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
            //View view = (TextView) getView().findViewById(R.id.myfraghome);

            Cursor cursor = (Cursor) databaseHelper.getTransactions();
            Calendar cal = Calendar.getInstance();
            int currentMonth = cal.get(Calendar.MONTH);

            StringBuffer sb = new StringBuffer();
            Integer[] months = new Integer[13];
            for (int i = 0; i < 13; i++) {
                months[i] = 0;
            }
            //month at 5 and 6
            while (cursor.moveToNext()) {
                sb.append(cursor.getString(1) + "---> " + cursor.getString(2) + "\n");
                int month = Integer.parseInt("" + sb.charAt(5) + sb.charAt(6));
                months[month] += Integer.parseInt(cursor.getString(2));
                months[12] = Integer.parseInt("" + sb.charAt(0) + sb.charAt(1) + sb.charAt(2) + sb.charAt(3));
            }

            Log.d(TAG, "Current Month   --- " + currentMonth);

            Log.d(TAG, sb.toString());

            ArrayList<String> arrayList = new ArrayList<String>();
            for (int s : months) {
                arrayList.add(String.valueOf(s));
            }

            TextView spent = (TextView) getView().findViewById((R.id.tvspend));
            int totalSpent = months[currentMonth];
            spent.setText("Spent :" + Integer.toString(totalSpent));
        }
        else{
            Log.d(TAG,"\n\n\nThsjsnnisndxi\n\n\n");
        }

    }


    private static final String TAG = "FRAG_HOME";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;

    public frag_home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frag_home.
     */
    // TODO: Rename and change types and number of parameters
//    public static frag_home newInstance(String param1, String param2) {
//        frag_home fragment = new frag_home();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
    @Override
    public void onCreate (Bundle savedInstanceState) {

        DatabaseHelper myDB;
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate chal gaya");

    }


    public static Integer amount = 10;



    TextView tvhome;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_home, container, false);
//        tvhome = (TextView)view.findViewById(R.id.tvhome);
//        tvhome.setText("welcome to home");

        CircularProgressBar circularProgressBar = (CircularProgressBar)view.findViewById(R.id.pbar);
        circularProgressBar.setProgress(80);

        Cursor cursor = (Cursor) databaseHelper.getTransactions();
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH);

        StringBuffer sb = new StringBuffer();
        Integer[] months = new Integer[13];
        for(int i=0;i<13;i++){
            months[i] = 0;
        }
        //month at 5 and 6
        while(cursor.moveToNext()) {
            sb.append(cursor.getString(1) + "---> " + cursor.getString(2) + "\n");
            int month = Integer.parseInt(""+sb.charAt(5) + sb.charAt(6));
            months[month] += Integer.parseInt(cursor.getString(2));
            months[12] = Integer.parseInt(""+sb.charAt(0) + sb.charAt(1) + sb.charAt(2) + sb.charAt(3)) ;
        }

        Log.d(TAG,"Current Month   --- "+currentMonth);

        Log.d(TAG,sb.toString());

        ArrayList<String> arrayList = new ArrayList<String>();
        for(int s:months) {
            arrayList.add(String.valueOf(s));
        }

        TextView spent = (TextView) view.findViewById((R.id.tvspend));
        int totalSpent = months[currentMonth];
        spent.setText("Spent :"+Integer.toString(totalSpent));

        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

}
