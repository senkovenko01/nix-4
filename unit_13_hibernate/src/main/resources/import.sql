insert into public.courses (course_name) values ('java');
insert into public.courses (course_name) values ('QA');
insert into public.courses (course_name) values ('js');

insert into public.groups (group_name, course_id) values ('java-class', '1');
insert into public.groups (group_name, course_id) values ('QA-class', '2');
insert into public.groups (group_name, course_id) values ('js-class', '3');

insert into public.topics (topic_name) values ('collections');
insert into public.topics (topic_name) values ('OOP');
insert into public.topics (topic_name) values ('Strings');
insert into public.topics (topic_name) values ('QA automation');
insert into public.topics (topic_name) values ('Context Manager');

insert into public.marks (mark) values ('20');
insert into public.marks (mark) values ('21');
insert into public.marks (mark) values ('22');
insert into public.marks (mark) values ('23');
insert into public.marks (mark) values ('19');
insert into public.marks (mark) values ('30');

insert into public.teachers (first_name, last_name) values ('Oleg', 'Ivanov');
insert into public.teachers (first_name, last_name) values ('Sasha', 'Petrov');
insert into public.teachers (first_name, last_name) values ('Dima', 'Popov');

insert into public.students (first_name, last_name, group_id, mark_id) values ('Igor', 'Bobrov', '1', '6');
insert into public.students (first_name, last_name, group_id, mark_id) values ('Katya', 'Belova', '1', '4');
insert into public.students (first_name, last_name, group_id, mark_id) values ('Pasha', 'Solyanik', '1', '6');
insert into public.students (first_name, last_name, group_id, mark_id) values ('Sasha', 'Zinchenko', '2', '1');
insert into public.students (first_name, last_name, group_id, mark_id) values ('Masha', 'Litvin', '2', '2');
insert into public.students (first_name, last_name, group_id, mark_id) values ('Alina', 'Kursha', '2', '3');
insert into public.students (first_name, last_name, group_id, mark_id) values ('Kristina', 'Skryabina', '3', '5');
insert into public.students (first_name, last_name, group_id, mark_id) values ('Andey', 'Andreev', '3', '6');
insert into public.students (first_name, last_name, group_id, mark_id) values ('Ivan', 'Surkov', '3', '5');

insert into public.lessons (description, date, time,group_id, teacher_id, topic_id ) values ('first lesson', '21.07.2021','15:00:00', '3','3','2');
insert into public.lessons (description, date, time,group_id, teacher_id, topic_id ) values ('first lesson', '15.06.2021','15:00:00','1' ,'1','2');
insert into public.lessons (description, date, time,group_id, teacher_id, topic_id ) values (null, '17.06.2021','15:00:00', '1','2','1');
insert into public.lessons (description, date, time,group_id, teacher_id, topic_id ) values ('context manager 1 lesson', '13.08.2021','15:00:00', '2','3','5');
insert into public.lessons (description, date, time,group_id, teacher_id, topic_id ) values ('first lesson continue', '15.06.2021','18:00:00','1' ,'1','2');