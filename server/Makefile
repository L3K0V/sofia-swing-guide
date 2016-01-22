install: bin/python3

bin/python3:
    virtualenv .
    bin/pip3 install -r requirements.txt

serve: bin/python3
    bin/python3 ./manage.py runserver 8888

deploy: bin/python3
    bin/python3 ./manage.py collectstatic --clear --noinput
    touch swing/wsgi.py  # trigger reload

clean:
    rm -rf bin/ lib/ build/ dist/ *.egg-info/ include/ local/
