package th.ac.srru.fms.showfms.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import th.ac.srru.fms.showfms.MainActivity;
import th.ac.srru.fms.showfms.R;
import th.ac.srru.fms.showfms.utility.AddNewUserToServer;
import th.ac.srru.fms.showfms.utility.MyAlert;
import th.ac.srru.fms.showfms.utility.MyConstant;

public class RegisterFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolbar
        createToolbar();


    }// Main Method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()== R.id.itemUpload) {

         uploadValueToServer();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void uploadValueToServer() {

     //   get value from Edittext
        EditText nametEditText = getView().findViewById(R.id.edtMame);
        EditText userEditText = getView().findViewById(R.id.edtUser);
        EditText passwordEditText = getView().findViewById(R.id.edtPassword);

//        Chang Dato Type From EditText to String

        String nameString = nametEditText.getText().toString().trim();//trim หมายถึงถ้ามีการกรอกแล้วมีช่องว่างให้ตัดทิ้ง
        String userString = userEditText.getText().toString().trim();
        String passwordString = passwordEditText.getText().toString().trim();


      //  Check Spece เช็คว่ามีการกรอกครบทุกช่องไหม
        if (nameString.isEmpty() ||userString.isEmpty()|| passwordString.isEmpty()) {
//            Have Space

            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.normalDialog("Have Space", "Please Fill All Blank");


        } else {

//         No Space
            try {

                MyConstant myConstant = new MyConstant();
                AddNewUserToServer addNewUserToServer = new AddNewUserToServer(getActivity());
                addNewUserToServer.execute(nameString,userString,passwordString,
                        myConstant.getUrlAddUser());

                String result = addNewUserToServer.get();
                Log.d("26ApilV1", "result==>" + result);

                if (Boolean.parseBoolean(result)) {
                    getActivity().getSupportFragmentManager().popBackStack();
                } else {
                    Toast.makeText(getActivity(), "Error Cannot Upload",
                            Toast.LENGTH_SHORT).show();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }



    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_register,menu);

    }

    private void createToolbar() {
        Toolbar toolbar = getActivity().findViewById(R.id.toolbarRegister);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

//        Setup Title
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Register");
        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("Please Fill All Blank");

//        Setup Navigation Icon
        ((MainActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container,false);
        return view;
    }
}
