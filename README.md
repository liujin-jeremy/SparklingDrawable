## 闪闪效果

### 引入

```
compile 'tech.liujin:sparkling:1.0.2'
```

### 效果图

![](img/pic00.gif)



## 使用

textView

```
<tech.liujin.sparkling.SparklingTextView
    android:id="@+id/textView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="16dp"
    android:layout_marginStart="8dp"
    android:layout_marginEnd="8dp"
    android:layout_marginLeft="8dp"
    android:layout_marginRight="8dp"
    android:text="Welcome"
    android:textColor="@android:color/black"
    android:textSize="32sp"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"/>
```

drawable

```
mImageView.setBackgroundDrawable( new SparklingDrawable() );
```

