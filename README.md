# sofia-swing-guide
Quick install guide

```
$ brew install geos
$ brew install spatialite-tools
$ brew install gdal
```

```
$ pip3 install -r requirements.txt
$ python3 manage.py makemigrations
$ python3 manage.py migrate
```

Create superuser, follow instructions to enable write access and manage oauth applications

```
$ python3 manage.py createsuperuser
```

Run the server

```
$ python3 manage.py runserver
```

Login
To access oauth navigate to: `serverurl/oauth2/applications/`

https://django-oauth-toolkit.readthedocs.org/en/latest/tutorial/tutorial.html

## Deployment

```
mkdir -p /var/git/yourapp.git
mkdir -p /var/www/yourapp
```

```
cd /var/git/yourapp.git
git init --bare .
```

Then copy `post-receive.sample` to hooks folder in newly created bare repository.
And make it executable.

```
chmod +x /var/git/yourapp.git/hooks/post-receive
```

 ```
 git remote add production ssh://user@server:/var/git/yourapp.git
 ```

 ```
 $ git push production master

...
Counting objects: 862, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (437/437), done.
Writing objects: 100% (817/817), 121.16 KiB, done.
Total 817 (delta 608), reused 452 (delta 332)
remote: Deploying into /var/www/yourapp
...
remote: bin/python setup.py develop
...
...
remote: 345 static files copied.
To server:/var/git/yourapp.git
   2fe81f4..76a3fb8  master -> master
```
