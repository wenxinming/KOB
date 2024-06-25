scp dist/js/*.js kob:kob/acapp/
scp dist/css/*.css kob:kob/acapp/

ssh kob 'cd kob/acapp/ && ./rename.sh'
