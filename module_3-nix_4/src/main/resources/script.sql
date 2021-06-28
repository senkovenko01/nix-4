insert into public.categories (expense_name) values ('taxes');
insert into public.categories (expense_name) values ('shopping');
insert into public.categories (expense_name) values ('communal payments');
insert into public.categories (income_name) values ('salary');
insert into public.categories (income_name) values ('transfer');
insert into public.categories (income_name) values ('social assistance');

insert into users(email) values ('petrenko2000@gmail.com');
insert into users(email) values ('olegmaster123@gmail.com');

insert into public.accounts (account_name, balance, user_id) values ('Personal account', '10500', '1');
insert into public.accounts (account_name, balance, user_id) values ('Spare account', '7500', '1');
insert into public.accounts (account_name, balance, user_id) values ('Personal account', '10000', '2');
insert into public.accounts (account_name, balance, user_id) values ('Spare account', '25000', '2');


insert into public.operations(passed_at, transaction, account_id) values ('15.04.2020', '45000', '1');
insert into public.operations_categories(operation_id, category_id) values ('1', '4');
insert into public.operations(passed_at, transaction, account_id) values ('17.01.2021', '-34500', '1');
insert into public.operations_categories(operation_id, category_id) values ('2', '2');
insert into public.operations(passed_at, transaction, account_id) values ('17.01.2021', '10000', '2');
insert into public.operations_categories(operation_id, category_id) values ('3', '6');

