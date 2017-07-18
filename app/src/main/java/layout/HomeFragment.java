package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import grimreaper.bookworm.R;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    Button signUp;
    Button signIn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        signUp = (Button)rootView.findViewById(R.id.signup);
        signUp.setOnClickListener(this);
        signIn = (Button)rootView.findViewById(R.id.signin);
        signIn.setOnClickListener(this);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int button_id) {
        if (mListener != null) {
            mListener.onButtonPressed(button_id);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        onButtonPressed(v.getId());
    }

    public interface OnFragmentInteractionListener {
        void onButtonPressed(int button_id);
    }
}
