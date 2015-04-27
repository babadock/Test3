package app.test3;

import java.io.File;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class Test3 extends ActionBarActivity {

	protected static final String TAG = "FROM_TEST3";
	private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
		@Override
		public void onManagerConnected(int status) {
			switch (status) {
			case LoaderCallbackInterface.SUCCESS: {
				Log.i(TAG, "OpenCV loaded successfully");

				File root = Environment.getExternalStorageDirectory();
				File file = new File(root, "girl.jpg");
				Log.i(TAG, file.getAbsolutePath());
				Log.i(TAG, file.exists() ? "YES" : "NO");
				//Test3Processor test = new Test3Processor();
				Test3Processor.doSomething(file.getAbsolutePath());
			}
				break;
			default: {
				super.onManagerConnected(status);
			}
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test3);
		/*
		 * Test3Processor test = new Test3Processor(); test.doSomething("");
		 */
	}

	@Override
	protected void onResume() {
		super.onResume();
		OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_3, this,
				mLoaderCallback);

	}
}
