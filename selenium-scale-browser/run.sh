#Start the grid with 2 container
docker-compose -f grid.yaml up --scale chrome=2 -d

#run the suite with chrome
BROWSER=chrome docker-compose up

docker-compose -f grid.yaml up --scale firefox=2 -d
BROWSER=firefox docker-compose up
docker-compose -f grid.yaml down
docker-compose down





