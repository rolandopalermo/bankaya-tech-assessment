CREATE TABLE public.audit_logs
(
    id                integer                NOT NULL,
    method            character varying(300) NOT NULL,
    remote_ip_address character varying(40)  NOT NULL,
    creation_date     timestamp with time zone DEFAULT now()
);