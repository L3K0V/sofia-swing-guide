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
