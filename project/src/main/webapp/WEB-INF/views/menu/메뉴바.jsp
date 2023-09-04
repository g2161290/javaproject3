<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>menu</title>
  <style>
    body, ul, li{
  margin : 0;
  padding : 0;
  list-style : none;
}

a{
  text-decoration: none;
  color:inherit;
  font-weight : bold;
}

.box {
  text-align : center;
}

.box > ul {
  background-color : #afafaf;
  display:inline-block;
  padding : 0 20px;
}

.box > ul > li {
  display:inline-block;
}

.box > ul > li > a{
    display:inline-block;
    padding : 8px 50px;
}

.box > ul > li:hover > a{
    background-color : black;
    color : white;
}
  </style>
</head>
<body>
  <nav class="box">
    <ul>
      <li><a href="memberlist.do">Member</a></li>
      <li><a href="#">menu 2</a></li>
      <li><a href="#">menu 3</a></li>
    </ul>
  </nav>
  
</body>
</html>