package tech.threekilogram.textlightlighttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import tech.threekilogram.sparkling.SparklingDrawable;

public class MainActivity extends AppCompatActivity {

      private TextView mTextView;
      private View     mImageView;

      @Override
      protected void onCreate ( Bundle savedInstanceState ) {

            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );
            initView();
      }

      private void initView ( ) {

            mTextView = findViewById( R.id.textView );
            mImageView = findViewById( R.id.imageView );

            mImageView.setBackgroundDrawable( new SparklingDrawable() );
      }
}
