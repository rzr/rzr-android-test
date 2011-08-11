package fr.online.rzr.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SlidingDrawer;

public class TestActivity extends Activity implements OnClickListener {

	static String TAG = "TestActivity";

	static EditText mText = null;	

	public static String println(Object object) {
		String res = (object != null) ? object.toString() : "<null>";
		res += "\n";
		Log.d(TAG, "log : " + res);
		System.out.println(res);

		if (mText != null) {
			mText.append(res);
		}

		return res;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		mText = (EditText) TestActivity.this.getWindow().findViewById(
				R.id.editText1);

		Button view = (Button) findViewById(R.id.button1);
		if (view != null) {
			view.setOnClickListener(this);
		}

	}

	public void onClick(View v) {

		if (v != null)
			switch (v.getId()) {
			case R.id.button1:
				run();
				break;
			default:

			}

	}

	int mChannelConfig = AudioFormat.CHANNEL_CONFIGURATION_MONO;
	int mAudioFormat = AudioFormat.ENCODING_PCM_16BIT;

	int mDuration = 1;
	
	/** @url: http://en.wikipedia.org/wiki/Sampling_rate#Audio **/
	static final int[] mSampleRates = { 192000, 176400, 96000, 88200, 50400, 50000,
			48000, 47250, 44100, 44056, 32000, 24000, 22050, 16000, 11025, 8000 };

	void run() {

		for (int i = 0; i < mSampleRates.length; i++) {

			println("");
			try {
				testSampleRate(mSampleRates[i]);

			} catch (Exception e) {
				println(e);
				e.printStackTrace();
			}

		}

	}

	public void testSampleRate(int sampleRate) throws Exception {

		AudioRecord audioRecord = null;
		
		int sizeInBytes = -1;
		int minBufferSize = 0;
		ByteBuffer audioBuffer = null;  

		minBufferSize = AudioTrack.getMinBufferSize(sampleRate, mChannelConfig,
				mAudioFormat);

		println("AudioTrack: rate=" + sampleRate + " size=" + minBufferSize);

		sizeInBytes = (int) ( mDuration * minBufferSize);

		if (sizeInBytes > 0) {
			audioBuffer = ByteBuffer.allocateDirect( sizeInBytes );
			
			audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
					sampleRate, mChannelConfig, mAudioFormat, sizeInBytes);
		}

		println(audioRecord);
		
		println("state=" + audioRecord.getState() + " ? " + audioRecord.STATE_INITIALIZED );
		// println("rate=" + audioRecord.getSampleRate());

		audioRecord.startRecording();
		int status = audioRecord.read(audioBuffer, sizeInBytes );
		println( "read=" + status + " ? " + sizeInBytes );
		
		audioRecord.stop();
		audioRecord.release();

		// TODO playback

	}

}