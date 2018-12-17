# Kongzue StackLabel
Kongzue StackLabel 是堆叠标签组件，适合快速完成需要堆叠标签的场景，例如“搜索历史”、“猜你喜欢”等功能。

<a href="https://github.com/kongzue/StackLabel/">
<img src="https://img.shields.io/badge/StackLabel-1.1.1-green.svg" alt="Kongzue StackLabel">
</a>
<a href="https://bintray.com/myzchh/maven/StackLabel/1.1.1/link">
<img src="https://img.shields.io/badge/Maven-1.1.1-blue.svg" alt="Maven">
</a>
<a href="http://www.apache.org/licenses/LICENSE-2.0">
<img src="https://img.shields.io/badge/License-Apache%202.0-red.svg" alt="License">
</a>
<a href="http://www.kongzue.com">
<img src="https://img.shields.io/badge/Homepage-Kongzue.com-brightgreen.svg" alt="Homepage">
</a>

Demo预览图如下：

![StackLabel](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/stacklabel_demo.png)

Demo下载地址：https://fir.im/stacklabel

### 优势
- 轻松易使用，快速创建，满足绝大多数堆叠标签使用场景。

### 使用方法

1) 从 Maven 仓库或 jCenter 引入：
Maven仓库：
```
<dependency>
  <groupId>com.kongzue.stacklabel</groupId>
  <artifactId>stacklabelview</artifactId>
  <version>1.1.1</version>
  <type>pom</type>
</dependency>
```
Gradle：
在dependencies{}中添加引用：
```
implementation 'com.kongzue.stacklabel:stacklabelview:1.1.1'
```

2) 从XML布局文件创建：
```
<com.kongzue.stacklabelview.StackLabel xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/stackLabelView"
    android:layout_width="match_parent"
    android:layout_height="120dp"
    app:textColor="#e6000000"
    app:itemMargin="4dp"
    app:paddingHorizontal="12dp"
    app:paddingVertical="8dp"
    app:deleteButton="false"
    app:textSize="12dp"
    />
```

其中支持的自定义属性解释如下：

字段 | 含义 | 类型
---|---|---
app:textColor  | 标签文本颜色  | ColorInt
app:itemMargin  | 标签外边距  | int(像素)
app:paddingHorizontal  | 标签内左右间距  | int(像素)
app:paddingVertical  | 标签内上下间距  | int(像素)
app:deleteButton  | 默认是否显示删除按钮  | boolean
app:textSize  | 标签文本字号  | int(像素)
app:deleteButtonImage  | 删除图标  | resId(资源id，例如@mipmap/img_delete)
app:labelBackground  | Label背景图  | resId(资源id，例如@mipmap/img_delete)

3) 添加内容：

StackLabel 目前仅支持纯文本标签表现，您可以将要显示的 String 字符串文本添加为 List 集合设置给 StackLabel，就会呈现想要的内容，范例如下：
```
labels = new ArrayList<>();
labels.add("花哪儿记账");
labels.add("给未来写封信");
labels.add("密码键盘");
labels.add("抬手唤醒");
labels.add("Cutisan");
labels.add("记-专注创作");
labels.add("我也不知道我是谁");
labels.add("崩崩崩");
labels.add("Android");
labels.add("开发");
stackLabelView.setLabels(labels);
```

要实现标签点击，则需要设置点击监听器：
```
stackLabelView.setOnLabelClickListener(new OnLabelClickListener() {
    @Override
    public void onClick(int index, View v, String s) {
        Toast.makeText(MainActivity.this, "点击了：" + s, Toast.LENGTH_SHORT).show();
    }
});
```

您可以在代码中使用 setDeleteButton(boolean) 控制 StackLabel 删除模式的开关：
```
stackLabelView.setDeleteButton(ture);
```

当 DeleteButton 开启时，点击任何标签即应删除该标签：
```
stackLabelView.setOnLabelClickListener(new OnLabelClickListener() {
    @Override
    public void onClick(int index, View v, String s) {
        if (stackLabelView.isDeleteButton()) {
            //删除并重新设置标签
            labels.remove(index);
            stackLabelView.setLabels(labels);
        } else {
            Toast.makeText(MainActivity.this, "点击了：" + s, Toast.LENGTH_SHORT).show();
        }
    }
});
```

以上，即 StackLabel 的基本使用流程。

## 开源协议
```
Copyright Kongzue StackLabel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## 更新日志
v1.1.1:
- 增加了判空避免空指针问题；

v1.1.0:
- 新增属性 deleteButtonImage 和 labelBackground 设置属性；

v1.0:
- 全新发布；

