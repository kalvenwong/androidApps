package com.filecontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.service.FileService;


public class MainActivity extends Activity {

	 EditText filecontentText;
	 EditText filenameText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       filecontentText=(EditText)  findViewById(R.id.filecontent);
       filenameText=(EditText)   findViewById(R.id.filename);
      Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new ButtonClickListener());
    }
    private final class ButtonClickListener implements View.OnClickListener{

		public void onClick(View v) {
			String filename=filenameText.getText().toString();
			String filecontent=filecontentText.getText().toString();
			FileService service =new FileService(getApplicationContext());
			try {
				service.save(filename, filecontent);
				Toast.makeText(getApplicationContext(), R.string.success, 1).show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), R.string.fail, 1).show();
			}
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
