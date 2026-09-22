git语法偏向linux风格

接下来的指令都在 Git Bash上进行
因为指令都是linux风格的, 所以这些指令基本都是针对目录的, 也就是你要在哪个目录建立仓库就要先cd到这个目录

## 在git上进行版本记录

git init 直接在当前目录创建仓库

git add . 把当前目录下的所有内容先放入暂存区, 我感觉这个语句的作用就是
把指定内容放入缓冲区, 确认想要版本记录的范围, 

git reset 如果指定文件范围错了, 而且没执行commit就可以用这个去清空暂存区, 重新add

git commit -m "备注内容"  把放入缓冲区的内容提交给git进行版本记录, 也就是这步过后, 记录版本的目的就完成了

## 把版本记录上传到GitHub

git remote add origin_1 "GitHub仓库的地址"这一步就是在当前的git下关联一下GitHub上的仓库 顺便起个别名, 这样你才能把版本记录上传到GitHub

git remote -v 查看所有仓库, 加上 -v 才能查看别名和完整地址, 依旧

git remote remove 仓库名   删除仓库

![[Pasted image 20260922161029.png]]
git push  origin_1 master把整个版本链push到GitHub的仓库, 版本链是记录在git里面的所有的commit过的历史版本

git log 可以在git本地查看提交过的版本
