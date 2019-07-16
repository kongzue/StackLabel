package com.kongzue.stacklabel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.kongzue.stacklabelview.StackLabel;
import com.kongzue.stacklabelview.interfaces.OnLabelClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private StackLabel stackLabelView;
    private Switch switchDelete;
    private EditText editMaxNum;
    private Switch switchSelect;
    private EditText editAdd;
    private Button btnAdd;
    
    private List<String> labels;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        stackLabelView = findViewById(R.id.stackLabelView);
        switchDelete = findViewById(R.id.switchDelete);
        editMaxNum = findViewById(R.id.edit_maxNum);
        switchSelect = findViewById(R.id.switchSelect);
        editAdd = findViewById(R.id.edit_add);
        btnAdd = findViewById(R.id.btn_add);
        
        //labels = new ArrayList<>();
        //labels.add("花哪儿记账");
        //labels.add("给未来写封信");
        //labels.add("密码键盘");
        //labels.add("抬手唤醒");
        //labels.add("Cutisan");
        //labels.add("记-专注创作");
        //labels.add("我也不知道我是谁");
        //labels.add("崩崩崩");
        //labels.add("Android");
        //labels.add("开发");
        //
        //stackLabelView.setLabels(labels);
        stackLabelView.setLabels(new String[]{"花哪儿记账","给未来写封信","密码键盘","抬手唤醒"});
        
        stackLabelView.setOnLabelClickListener(new OnLabelClickListener() {
            @Override
            public void onClick(int index, View v, String s) {
                if (switchDelete.isChecked()) {
                    labels.remove(index);
                    stackLabelView.setLabels(labels);
                } else {
                    Toast.makeText(MainActivity.this, "点击了：" + s, Toast.LENGTH_SHORT).show();
                    if (stackLabelView.isSelectMode()) {
                        for (int i : stackLabelView.getSelectIndexList()) {
                            Log.i(">>>", "select: " + i);
                        }
                    }
                }
            }
        });
        
        switchDelete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                stackLabelView.setDeleteButton(isChecked);
            }
        });
        
        switchSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                
                List<String> selectLabels = new ArrayList<>();
                selectLabels.add("Android");
                selectLabels.add("Cutisan");
                selectLabels.add("密码键盘");
                stackLabelView.setSelectMode(isChecked, selectLabels);
            }
        });
        
        editMaxNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            
            }
            
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            
            }
            
            @Override
            public void afterTextChanged(Editable s) {
                String str = editMaxNum.getText().toString();
                if (str != null && !str.isEmpty()) {
                    stackLabelView.setMaxSelectNum(Integer.parseInt(str));
                } else {
                    stackLabelView.setMaxSelectNum(0);
                }
            }
        });
        
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editAdd.getText().toString().trim();
                if (s != null && !s.isEmpty()) {
                    labels.add(s);
                    stackLabelView.setLabels(labels);
                }
            }
        });
    }
}
