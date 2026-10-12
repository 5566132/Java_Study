## 把版本记录上传到GitHub

git remote add origin_1 "GitHub仓库的地址"   这一步就是在当前的git下关联一下GitHub上的仓库 顺便起个别名, 这样你才能把版本记录上传到GitHub

git remote -v 查看所有仓库, 加上 -v 才能查看别名和完整地址, 依旧

git remote remove 仓库名   删除仓库

![[Pasted image 20260922161029.png]]
git push  origin_1 master把整个版本链push到GitHub的仓库, 版本链是记录在git里面的所有的commit过的历史版本

git log 可以在git本地查看提交过的版本