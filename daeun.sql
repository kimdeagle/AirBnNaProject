select * from tblMileage where seqMember=1;


-- 한달치 마일리지
select 
    sum(mi.saveM)-sum(mi.useM) as monthM
from tblMember m
    inner join tblMileage mi
        on m.seq = mi.seqMember
where mi.seqMember = 1 and mi.regdate between sysdate-30 and sysdate;

-- 총 마일리지
select
    totalM,
    seqMember
from ( select 
            mi.totalM,
            mi.seqMember
        from tblMember m
            inner join tblMileage mi
                on m.seq = mi.seqMember
        order by mi.regdate desc )
where rownum = 1 and seqMember = 1;


select *
from tblMember m
    inner join tblBook b
        on b.seqmember = m.seq
            inner join tblReview r
                on r.seqbook = b.seq
                    inner join tblDibs d
                       on d.seqMember = m.seq;
                       
select * from tblBook;

-- 회원별 예약 수
select 
    count(*)
from tblMember m
    inner join tblBook b
        on b.seqmember = m.seq
group by m.seq;


select * from tbltRIPINFO;
select * from tbltripinfocmt;

select 
    m.seq,
    m.pic,
    m.id
from tblTripinfocmt tpc
    inner join tblMember m
        on m.seq = tpc.seqmember;