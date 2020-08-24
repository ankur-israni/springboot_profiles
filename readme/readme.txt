1) URI
-----------
http://localhost:7000/swagger-ui.html

2) Profiles
-------------
There are three profiles:-
dev - loaded from application-dev.yaml
prod - loaded from application-prod.yaml
qa - loaded from application-qa.yaml

The parent of all these is the 'application.yaml' file.
Things that are common to all the profiles should be in this file.

Things that differ from profile to profile should be in the respective profile file.
