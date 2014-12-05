DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllReservations`()
BEGIN
   select r.id, r.reserveDate, ct.name as cottageName, r.price, r.paid, r.durationFrom, r.durationTo, pc.fName, pc.lName, c.name as companyName from reservation r
	left join privatecustomer pc on r.privatecustomer_fk = pc.id
	left join company c on r.company_fk = c.id
	left join cottage ct on r.cottage_fk = ct.id
	order by r.id;
   END$$
DELIMITER ;
