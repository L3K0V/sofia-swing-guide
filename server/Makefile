install: bin/python

bin/python:
	virtualenv .
	bin/pip3 install -r requirements.txt

serve: bin/python
	bin/python3 ./manage.py runserver 8888

deploy: bin/python
	bin/python3 ./manage.py collectstatic --clear --noinput
	touch swing/wsgi.py	# trigger reload

clean:
	rm -rf bin/ lib/ build/ dist/ *.egg-info/ include/ local/
