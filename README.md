# Kongzue StackLabel
Kongzue StackLabel 是堆叠标签组件，适合快速完成需要堆叠标签的场景，例如“搜索历史”、“猜你喜欢”等功能。

<a href="https://github.com/kongzue/StackLabel/">
<img src="https://img.shields.io/badge/StackLabel-1.1.9-green.svg" alt="Kongzue StackLabel">
</a>
<a href="https://bintray.com/myzchh/maven/StackLabel/1.1.9/link">
<img src="https://img.shields.io/badge/Maven-1.1.9-blue.svg" alt="Maven">
</a>
<a href="http://www.apache.org/licenses/LICENSE-2.0">
<img src="https://img.shields.io/badge/License-Apache%202.0-red.svg" alt="License">
</a>
<a href="http://www.kongzue.com">
<img src="https://img.shields.io/badge/Homepage-Kongzue.com-brightgreen.svg" alt="Homepage">
</a>

Demo预览图如下：

![StackLabel](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/stacklabel_demo.png)

从 1.1.3 版本起，亦可实现多选效果：

![StackLabel](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/stacklabel_select_demo.png)

Demo下载地址：<http://beta.kongzue.com/stacklabel>

## 优势
- 轻松易使用，快速创建，满足绝大多数堆叠标签使用场景。

## StackLabel 使用方法

### MavenCentral 源

<div>
最新版本：
<a href="https://github.com/kongzue/StackLabel/releases"><img src="https://img.shields.io/badge/MavenCentral%20Release-1.2.0-green.svg" alt="StackLabel Release"></a></div>

1) 在 project 的 build.gradle 文件中找到 `allprojects{}` 代码块添加以下代码：

```
allprojects {
    repositories {
        google()
        mavenCentral()      //增加 mavenCentral 仓库
    }
}
```

⚠️请注意，使用 Android Studio 北极狐版本（Arctic Fox）创建的项目，需要您前往 settings.gradle 添加上述 jitpack 仓库配置。

2) 在 app 的 build.gradle 文件中找到 `dependencies{}` 代码块，并在其中加入以下语句：

```
implementation "com.kongzue.stacklabel:StackLabel:1.2.0"
```

### Jitpack 源

<div>
最新版本：
<a href="https://jitpack.io/#kongzue/StackLabel"><img src="https://jitpack.io/v/kongzue/StackLabel.svg" alt="Jitpack.io"></a> <a href="https://github.com/kongzue/StackLabel/releases"><img src="https://img.shields.io/github/v/release/kongzue/StackLabel?color=green" alt="查看最新编译版本"></a> 
</div>

1) 在 project 的 build.gradle 文件中找到 `allprojects{}` 代码块添加以下代码：

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }      //增加 jitPack Maven 仓库
    }
}
```

⚠️请注意，使用 Android Studio 北极狐版本（Arctic Fox）创建的项目，需要您前往 settings.gradle 添加上述 jitpack 仓库配置。

2) 在 app 的 build.gradle 文件中找到 `dependencies{}` 代码块，并在其中加入以下语句：

```
implementation "com.github.kongzue.StackLabel:StackLabel:1.1.8"
```

### JCenter 源

1) 从 Maven 仓库或 jCenter 引入：
Maven仓库：
```
<dependency>
  <groupId>com.kongzue.stacklabel</groupId>
  <artifactId>stacklabelview</artifactId>
  <version>1.1.9</version>
  <type>pom</type>
</dependency>
```
Gradle：
在dependencies{}中添加引用：
```
implementation 'com.kongzue.stacklabel:stacklabelview:1.1.9'
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
    app:labels="标签1,标签2,标签3,标签4"
    />
```

其中支持的自定义属性解释如下：

字段 | 含义 | 类型
---|---|---
app:textColor  | 标签文本颜色  | ColorInt
app:itemMargin  | 标签外边距  | int(像素)
app:itemMarginHorizontal | 标签外横向边距  | int(像素)
app:itemMarginVertical | 标签外纵向边距  | int(像素)
app:paddingHorizontal  | 标签内左右间距  | int(像素)
app:paddingVertical  | 标签内上下间距  | int(像素)
app:deleteButton  | 默认是否显示删除按钮  | boolean
app:textSize  | 标签文本字号  | int(像素)
app:deleteButtonImage  | 删除图标  | resId(资源id，例如@mipmap/img_delete)
app:labelBackground  | Label背景图  | resId(资源id，例如@mipmap/img_delete)
app:selectMode  | 选择模式开关  | boolean
app:selectBackground  | 选中的Label背景图  | resId(资源id，例如@drawable/rect_label_bkg_select_normal)
app:selectTextColor  | 选中标签文本颜色  | ColorInt
app:maxSelectNum  | 最大选择数量  | int
app:minSelectNum  | 最小选择数量  | int
app:labels | 预设置标签 | String
app:maxLines | 最大可显示行数 | int

* 备注：预设置标签必须以英文“,”分隔才可生效

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

也可以使用 String 集合创建：
```
stackLabelView.setLabels(new String[]{"花哪儿记账","给未来写封信","密码键盘","抬手唤醒"});
```

另外在 1.1.8 版本中，加入了以下方法可动态添加：
```
stackLabelView.addLabel("新的标签");
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
### 删除模式

您可以在代码中使用 setDeleteButton(boolean) 控制 StackLabel 删除模式的开关：
```
stackLabelView.setDeleteButton(ture);
```

当 DeleteButton 开启时，点击任何标签即应删除该标签：
```
stackLabelView.setOnLabelClickListener(new OnLabelClickListener() {
    @Override
    public void onClick(int index, View v, String s) {
        if (stackLabelView.isDeleteButton()) {      //是否开启了删除模式
            //删除并重新设置标签
            labels.remove(index);
            stackLabelView.setLabels(labels);
        } else {
            Toast.makeText(MainActivity.this, "点击了：" + s, Toast.LENGTH_SHORT).show();
        }
    }
});
```

另外在 1.1.8 版本中，加入了以下方法可动态删除：
```
stackLabelView.remove(1);        //删除第1个索引的标签

stackLabelView.remove("标签2");   //删除名为“标签2”的标签
```

### 选择模式

从 1.1.2 版本起，新增了选择模式。

开启选择模式可以从 XML 布局中加入属性设置：
```
app:selectMode="true"
```
也可以从代码中开启：
```
stackLabelView.setSelectMode(true);
```

通过属性 maxSelectNum 可以设置最大可选数量，当值为 <=0 时不生效。

当属性 maxSelectNum = 1 时为单选模式，选择其他 Label 会自动取消之前选中的 Label。

当属性 maxSelectNum > 1 时为多选模式，选择数量大于 maxSelectNum 值时则无法选中更多的 Label。

maxSelectNum 也可在代码中通过 get/set 方法设置。

重复点击已选中的 Label 则会取消选中状态。

选中的角标集合可以通过以下方式获取：
```
stackLabelView.setOnLabelClickListener(new OnLabelClickListener() {
    @Override
    public void onClick(int index, View v, String s) {
        if (stackLabelView.isSelectMode()) {
            for (int i : stackLabelView.getSelectIndexList()) {     //获取已选定集合的角标，也可通过stackLabelView.getSelectIndexArray()获取数组形式
                Log.i(">>>", "select: " + i);
            }
        }
    }
});
```

另外可通过 setSelectMode(boolean, List<String>) 开启选择模式，并设置默认选中的标签；
```
List<String> selectLabels = new ArrayList<>();
selectLabels.add("Android");
selectLabels.add("Cutisan");
selectLabels.add("密码键盘");
stackLabelView.setSelectMode(isChecked, selectLabels);
```

以上，即 StackLabel 的基本使用流程。

### 其他方法
```
//判断存在
boolean isHave = stackLabelView.isHave("标签2");  //判断是否存在名为“标签2”的标签

//统计数量
int count = stackLabelView.count();              //统计所有标签数量

//重新加载全部标签
stackLabelView.reloadViews();
```

## StackLayout 使用方法
从 1.1.3 版本起新增组件 StackLayout，它继承自 RelativeLayout，可以将自定义的子布局直接放入即可实现堆叠排列。

![StackLayout](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/img_stacklayout.png)

使用方法：
```
<com.kongzue.stacklabelview.StackLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:itemMargin="4dp">
    
    <TextView
        android:layout_width="110dp"
        android:layout_height="40dp"
        android:padding="10dp"
        android:gravity="center"
        android:background="#FFD4D4"
        android:text="文本1" />
    <TextView
        android:layout_width="120dp"
        android:layout_height="40dp"
        android:padding="10dp"
        android:gravity="center"
        android:background="#FDFFB8"
        android:text="文本2" />
        
    <!--子布局-->
        
</com.kongzue.stacklabelview.StackLayout>
```

目前仅支持 itemMargin 属性调整子布局间距。

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
v1.1.9:
- 新增 maxLines 属性限定可显示的最大行数。

v1.1.8:
- 新增 `isHave(string label)`、`count()`、`reloadViews()` 等方法，使用方法详见“其他方法”；
- 新增 `addLabel(...)` 和 `remove(...)` 方法方便动态添加删除子标签；
- 更改了子布局排列方式，使用 layout 方法设置布局；
- 更改了宽度计算方式，彻底修复单标签长度超出屏幕的问题；

v1.1.7:
- 对单标签长度超出屏幕的问题进行了修复，目前使用了锁最大宽度的限制方式。

v1.1.6:
- 新增 app:itemMarginVertical 和 app:itemMarginHorizontal 属性，可自定义 Label 上下间距；
- 新增 setLabels(String[] arrays) 方便使用集合创建；
- 修复选中标签文字颜色设置纯白色无效的问题；

v1.1.5:
- 修复了取消选择时文字颜色依然是选择状态的问题；
- 新增 app:minSelectNum 属性，用于设定最小选中数量；

v1.1.4:
- 新增方法 setSelectMode(boolean, List<String>) 开启选择模式，并设置默认选中的标签；
- 新增属性 selectTextColor 控制选中文本颜色；

v1.1.3:
- 新增组件 StackLayout；

v1.1.2:
- 新增了选择模式；

v1.1.1:
- 增加了判空避免空指针问题；

v1.1.0:
- 新增属性 deleteButtonImage 和 labelBackground 设置属性；

v1.0:
- 全新发布；

