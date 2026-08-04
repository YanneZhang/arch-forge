**1.初次提交**

$ git init
Initialized empty Git repository in F:/My.Study.Notes/.git/

$ git add README.md

$ git commit -m "first commit"

$ git branch -M main

$ git remote add origin https://github.com/FayanZhang/My.Study.Notes.git

$ git push -u origin main

**2.再次提交**

$ git add README.md

$ git commit -m "first commit"

$ git push -u origin main

**3.下载最新**

$ git pull

**4.全部提交**

$ git add . && git commit -m "Your commit message" && git push origin main