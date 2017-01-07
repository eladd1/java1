//package com.example.elad.android5777.model.sharedPreference;
//
//        import android.os.Bundle;
//        import android.app.Activity;
//        import android.content.Context;
//        import android.content.SharedPreferences;
//        import android.content.SharedPreferences.Editor;
//
//// * Created by Elad on 04/12/2016.
////
////
//public class SharedPreferencesClass extends Activity {
//
//    private SharedPreferences sharedpreferences;
//    public static final String mypreference = "mypref";
//    public static final String Name = "nameKey";
//    public static final String password = "passKey";
//
//
//    public void add(String name, String pass) {
//
//        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
//        Editor editor = sharedpreferences.edit();
//        editor.putString(Name, name);
//        editor.putString(password, pass);
//        editor.commit();
//    }
//
//    public String getName() {
//
//        return (sharedpreferences.getString("nameKey","ERROR"));
//    }
//
//    public String getPass() {
//
//        return (sharedpreferences.getString("passKey","ERROR"));
//    }
//
////  using of shared prefrence:
////
////    package com.example.sharedpreferencesexm;
////
////    import android.support.v7.app.AppCompatActivity;
////    import android.os.Bundle;
////
////    import android.os.Bundle;
////    import android.app.Activity;
////    import android.content.Context;
////    import android.content.SharedPreferences;
////    import android.content.SharedPreferences.Editor;
////    import android.view.Menu;
////    import android.view.View;
////    import android.widget.TextView;
////
////    public class MainActivity extends Activity {
////        SharedPreferences sharedpreferences;
////        TextView name;
////        TextView email;
////        public static final String mypreference = "mypref";
////        public static final String Name = "nameKey";
////        public static final String Email = "emailKey";
////
////        @Override
////        protected void onCreate(Bundle savedInstanceState) {
////            super.onCreate(savedInstanceState);
////            setContentView(R.layout.activity_main);
////            name = (TextView) findViewById(R.id.etName);
////            email = (TextView) findViewById(R.id.etEmail);
////            sharedpreferences = getSharedPreferences(mypreference,
////                    Context.MODE_PRIVATE);
////            if (sharedpreferences.contains(Name)) {
////                name.setText(sharedpreferences.getString(Name, ""));
////            }
////            if (sharedpreferences.contains(Email)) {
////                email.setText(sharedpreferences.getString(Email, ""));
////
////            }
////
////        }
////
////        public void Save(View view) {
////            String n = name.getText().toString();
////            String e = email.getText().toString();
////            Editor editor = sharedpreferences.edit();
////            editor.putString(Name, n);
////            editor.putString(Email, e);
////            editor.commit();
////        }
////
////        public void clear(View view) {
////            name = (TextView) findViewById(R.id.etName);
////            email = (TextView) findViewById(R.id.etEmail);
////            name.setText("");
////            email.setText("");
////
////        }
////
////        public void Get(View view) {
////            name = (TextView) findViewById(R.id.etName);
////            email = (TextView) findViewById(R.id.etEmail);
////            sharedpreferences = getSharedPreferences(mypreference,
////                    Context.MODE_PRIVATE);
////
////            if (sharedpreferences.contains(Name)) {
////                name.setText(sharedpreferences.getString(Name, ""));
////            }
////            if (sharedpreferences.contains(Email)) {
////                email.setText(sharedpreferences.getString(Email, ""));
////
////            }
////        }
////
////        @Override
////        public boolean onCreateOptionsMenu(Menu menu) {
////            // Inflate the menu; this adds items to the action bar if it is present.
////            //  getMenuInflater().inflate(R.menu.main, menu);
////            return true;
////        }
////
////    }
//
//
//}
//
