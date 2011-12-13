package com.haseman.layouts;

import java.io.File;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;

public class LayoutExampleProjectActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_buttons);
        
        //setUsername("bob");
    }
    public void setUsername(String username){
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    	Editor ed = prefs.edit();
    	ed.putString("username", username);
    	try{
    		Method applyMethod = Editor.class.getDeclaredMethod("apply", new Class[]{});
    		if(applyMethod != null)
    			applyMethod.invoke(ed, new Object[]{});
    		else
    			ed.commit();
    	}catch(Exception error){
    		ed.commit();
    	}
    }
}