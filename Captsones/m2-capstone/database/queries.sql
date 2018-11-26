start transaction
CREATE SEQUENCE seq_reservation_id START 5000;

Select distinct site.site_id, site.campground_id, site.site_number, site.max_occupancy, site.accessible, site.max_rv_length,
site.utilities, (('2018-11-01'::date - '2018-10-01'::date) * c.daily_fee)::money from site
join campground as c on site.campground_id = c.campground_id
where site.campground_id = 6
and site_id not in
(SELECT distinct s.site_id
FROM site as s
JOIN campground as c
ON s.campground_id=c.campground_id
JOIN reservation as r
ON s.site_id = r.site_id
WHERE (r.from_date between '2018-10-01' and '2018-11-01')
OR (r.to_date between '2018-10-01' and '2018-11-01')
)
LIMIT 5;

SELECT s.*, c.daily_fee, r.reservation_id
FROM site as s
JOIN campground as c
ON s.campground_id=c.campground_id
JOIN reservation as r
ON s.site_id = r.site_id
WHERE (r.from_date between '2018-11-01' and '2018-11-07')
OR (r.to_date between '2018-11-01' and '2018-11-07')
ORDER BY r.reservation_id;

--Site res verification github
Select distinct * from site
join campground on site.campground_id = campground.campground_id
where site.campground_id = 1
and site_id not in
(select site.site_id from site
join reservation on reservation.site_id = site.site_id
where ‘12/31/18’ > reservation.from_date and ‘1/1/18’ < reservation.to_date order by daily_fee)
LIMIT 5;
--Limit 5;

-- show available site numbers
select site_number, max_occupancy, accessible, max_rv_length, utilities -- 3rd query--(daily_fee * (reservation.to_date - reservation.from_date)) as cost -- returns available site numbers and their fees daily
from site
join campground 
on campground.campground_id = site.campground_id
where site.campground_id = 1 
and site_id in (select site_id 
                    from reservation 
                    where (from_date <= '2018-11-01' and to_date >= '2018-11-07') 
                    group by site_id) 
--limit 5;

-- show booked site numbers
select site_number, max_occupancy, accessible, max_rv_length, utilities -- 3rd query--(daily_fee * (reservation.to_date - reservation.from_date)) as cost -- returns available site numbers and their fees daily
from site
join campground 
on campground.campground_id = site.campground_id
where site.campground_id = 1 
and site_id in (select site_id 
                    from reservation 
                    where (from_date <= '2018-11-01' and to_date >= '2018-11-01') 
                    group by site_id) 
limit 5;

--Can site double booked?
select count(reservation_id) as double_book
from reservation
where (from_date <= '2018-10-01' and to_date >= '2018-12-31')
group by site_id



--How many sites in each camp ground
select c.name, count(s.site_id) as total_sites
from campground c
inner join site s
on c.campground_id = s.campground_id
where name = 'Blackwoods'
group by c.name
order by total_sites desc;

-- getAllParks
select park_id, name, location, establish_date, area, visitors, description
from park
where park_id = ?;

-- getCampgroundByParkName
select c.campground_id, c.name, c.open_from_mm, c.open_to_mm, c.daily_fee
from park p
inner join campground c
on p.park_id = c.park_id
where p.name = 'Acadia';

-- getAllCampgrounds
select c.campground_id, c.name, c.open_from_mm, c.open_to_mm, c.daily_fee
from campground c
order by c.daily_fee
-- isCampgroundInSeason
select c.name, c.open_from_mm, c.open_to_mm,
case
when (extract(month from current_date) between c.open_from_mm::float and c.open_to_mm::float)
then 'IN SEASON'
else 'NOT IN SEASON'
end as in_season
from park p
inner join campground c
on p.park_id = c.park_id
where c.campground_id = '1';


--numberOfReservations
select *
from site s
inner join reservation r
on s.site_id = r.site_id
where r.from_date = '2018-11-01' AND r.to_date = '2018-11-07'




-- hasAvailability
select c.name, count(s.site_id) as total_sites, count(r.site_id) as booked_sites,
from campground c
inner join site s
on c.campground_id = s.campground_id
inner join reservation r
on r.site_id = s.site_id
where r.from_date = '2018-11-01' AND r.to_date = '2018-11-07'
group by c.name;








select p.park_id, p.name, p.location, p.establish_date, p.area, p.visitors, p.description,
case
when (extract(month from current_date) between c.open_from_mm::float and c.open_to_mm::float)
then 'OPEN'
else 'NOT OPEN'
end as Availability
from park p
inner join campground c
on p.park_id = c.park_id;














if extract(month from current_date) >= 5 AND extract(month from current_date) < 10
select p.park_id, p.name, p.location, p.establish_date, p.area, p.visitors, p.description
from park p
inner join campground c
on p.park_id = c.park_id;

else if extract(month from current_date) >= 5 AND extract(month from current_date) < 11
select p.park_id, p.name, p.location, p.establish_date, p.area, p.visitors, p.description
from park p
inner join campground c
on p.park_id = c.park_id
where c.campground_id is in (1, 3, 4, 5, 6, 7)
else if extract(month from current_date) >= 5 AND extract(month from current_date) < 11;



select extract(month from current_date)::date || "-" || extract(day from current_date)::varchar as today;






start transaction;

insert into reservation
values (DEFAULT, ?, ?, ?, ?, current_date);

SELECT * from reservation;

rollback;

