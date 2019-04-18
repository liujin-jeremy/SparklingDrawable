package tech.threekilogram.textlightlighttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import tech.threekilogram.sparkling.SparklingDrawable;
import tech.threekilogram.sparkling.LightLightTextView;

public class MainActivity extends AppCompatActivity {

      private LightLightTextView mTextView;
      private View               mImageView;

      @Override
      protected void onCreate ( Bundle savedInstanceState ) {

            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );
            initView();
      }

      private void initView ( ) {

            mTextView = (LightLightTextView) findViewById( R.id.textView );
            mImageView = findViewById( R.id.imageView );

            mImageView.setBackgroundDrawable( new SparklingDrawable() );
      }
}
