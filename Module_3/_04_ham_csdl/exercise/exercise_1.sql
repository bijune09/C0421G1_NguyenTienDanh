use quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from `subject`
where Credit = (select max(Credit) from `subject`);
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from mark
where Mark = (select max(Mark) from mark);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *, avg(Mark) as "avg mark" from student
left join mark on student.StudentId = mark.StudentId
group by student.StudentId
order by mark.mark desc;
