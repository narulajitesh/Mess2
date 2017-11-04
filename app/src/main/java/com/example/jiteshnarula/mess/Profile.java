package com.example.jiteshnarula.mess;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
    public static final int REQUEST_CAPTURE = 1, SELECT_FILE = 0;

    ImageView dp,edit;


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_profile, container, false);
        dp = (ImageView)v.findViewById(R.id.dp);
        edit = (ImageView)v.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hasCamera())

                {

                    Toast.makeText(getActivity(), "No Camera Found", Toast.LENGTH_SHORT).show();
                } else {
                    selectImage();

                }
            }
        });
        return v;
    }
    public void selectImage() {
        final CharSequence[] item = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
        ab.setTitle("Add Image");
        ab.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (item[i].equals("Camera")) {
                    Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cam, REQUEST_CAPTURE);


                } else if (item[i].equals("Gallery")) {
                    Intent gal = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    gal.setType("image/*");
                    gal.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(gal.createChooser(gal, "Select File"), SELECT_FILE);

                }
                if (item[i].equals("Cancel")) {
                    dialogInterface.dismiss();
                }

            }
        });

        AlertDialog a = ab.create();
        a.show();
    }
    public boolean hasCamera() {
        PackageManager getPackageManager=getActivity().getPackageManager();
        return getPackageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
