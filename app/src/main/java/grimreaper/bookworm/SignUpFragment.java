package grimreaper.bookworm;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SignUpFragment extends Fragment implements View.OnClickListener{

    private String signUpName;
    private String signUpEmail;
    private String signUpPassword;
    private EditText emailEdit , passwordEdit;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        Button signUpButton = (Button) rootView.findViewById(R.id.signUpUsingEmail);
        signUpButton.setOnClickListener(this);
        emailEdit = (EditText)rootView.findViewById(R.id.editEmail);
        passwordEdit = (EditText)rootView.findViewById(R.id.editPassword);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signUpUsingEmail:
                signUpEmail = emailEdit.getText().toString();
                signUpPassword = passwordEdit.getText().toString();
                int isValid = checkLoginCredentials(signUpEmail , signUpPassword);
                if(isValid == 1)
                    showDialog("Invalid Email Address");
                else if(isValid == 2)
                    showDialog("Password must be 4-20 characters");
                else
                    Log.d("goku" , "Signed Up"); //createUserAccout(signUpEmail , signUpPassword);
                break;
        }
    }

    void showDialog(String errorMessage){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("BookWorm")
                .setMessage(errorMessage)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                })
                .show();
    }

    int checkLoginCredentials(String email , String password){
        boolean validEmail = validateEmail(email);
        boolean validPassword = validatePassword(password);
        if(!validEmail){
            Log.d("goku", "Invalid Email");
            return 1;
        }else if(!validPassword){
            Log.d("goku", "Invalid Password");
            return 2;
        }else{
            Log.d("goku","Signed Up");
            return 3;
        }
    }

    boolean validateEmail(String email){
        boolean isValid = false , flag = false;
        for(int i = 0 ; i < email.length() ; i++){
            if(email.charAt(i) == '@')
                flag = true;
            if(flag && email.charAt(i) == '.')
                isValid = true;
        }
        return isValid;
    }

    boolean validatePassword(String password){
        return (password.length() >= 4 && password.length() <= 20);
    }
}
