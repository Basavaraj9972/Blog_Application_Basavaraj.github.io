This is the Blog Application After Extract this project create two tables `user` and `blog`
1)Table: user
Columns:
userId int AI PK 
name varchar(45) 
email varchar(45) 
phoneNo varchar(45) 
address varchar(245) 
userName varchar(45) 
password varchar(45) 
role enum('Admin','Viewer') 
createdDate datetime  default(CURRENT_TIMESTAMP)
lastLogindate datetime

while creating default for createdDate paste this CURRENT_TIMESTAMP

2)`blog`
Table: blog
Columns:
blogId int AI PK 
title varchar(255) 
contents varchar(1000) 
image_video varchar(555) 
createdDate datetime default(CURRENT_TIMESTAMP)
updatedDate datetime 
edit tinyint 
userId int

while creating default for createdDate paste this CURRENT_TIMESTAMP

After creating table if you add image link download the image or vedio then create one floder in Webapp imgfolder paste the image or vedio in this folder.
1) for example:  http://localhost:8080/BlogApplication_Task2/blogImages/seaNature.jpg
2) in above link localhost which you are using port number then projectName / folder which your are created then image or vedio name that is filename.jpg or videoname.mp4 anything is ok.

IN Admin
1)in Add Blog  give the valid userId
2) in Update give the valid BlogId and userId
3) in Delete give the valid BlogId

In Viewer part
1) serch though either title or DateTime
2) The Date time pattern is valid YYYY-MM-DD HH:MM:SS

