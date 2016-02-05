package senatest.sena1025844;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import senatest.sena1025844.entity.User;

public class FirebaseExample extends AppCompatActivity {

    final Activity activity=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);//Inicializar firebase
        final Firebase bdremota= new Firebase("https://incandescent-inferno-2209.firebaseio.com/");

        final EditText nombre= (EditText)findViewById(R.id.edit_fire_name);
        final EditText apellido= (EditText)findViewById(R.id.edit_fire_last_name);
        final EditText email= (EditText)findViewById(R.id.edit_fire_email );
        final EditText identificacion= (EditText)findViewById(R.id.edit_fire_identification);


        Button button = (Button)findViewById(R.id.button_fire_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!identificacion.getText().toString().isEmpty() ) {
                    User user = new User(nombre.getText().toString(),apellido.getText().toString(),
                            Double.valueOf(identificacion.getText().toString()), email.getText().toString());

                    bdremota.child("usuarios").child(identificacion.getText().toString()).setValue(user);
                    //  bdremota.child("kmilo").setValue(dato.getText().toString());
                }else{
                    Toast.makeText(activity, getResources().getText(R.string.message_validation), Toast.LENGTH_SHORT).show();
                }
            }
        });

/**************LEER****************/

        final EditText editText=(EditText)findViewById(R.id.read_fire_identification);
        Button buttonRead=(Button)findViewById(R.id.button_fire_read);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().isEmpty()){
                    Firebase bdusuario= new Firebase("https://incandescent-inferno-2209.firebaseio.com/usuarios/"
                            + editText.getText().toString()+"/");
                    bdusuario.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            User user=(User)dataSnapshot.getValue(User.class);
                            if(user!=null){
                                Toast.makeText(activity,"usuario encontrado "+ user.getName(),
                                        Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            Toast.makeText(activity,"error",
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
        });

    }
}
