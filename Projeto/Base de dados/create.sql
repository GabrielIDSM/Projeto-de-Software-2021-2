--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: image_conf; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image_conf (
    id integer NOT NULL,
    file_name character varying(255)
);


ALTER TABLE public.image_conf OWNER TO postgres;

--
-- Name: image_conf_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.image_conf_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.image_conf_id_seq OWNER TO postgres;

--
-- Name: image_conf_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.image_conf_id_seq OWNED BY public.image_conf.id;


--
-- Name: role_conf; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_conf (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.role_conf OWNER TO postgres;

--
-- Name: role_conf_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_conf_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_conf_id_seq OWNER TO postgres;

--
-- Name: role_conf_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_conf_id_seq OWNED BY public.role_conf.id;


--
-- Name: service_conf; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service_conf (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    query character varying(255) NOT NULL,
    image_id integer
);


ALTER TABLE public.service_conf OWNER TO postgres;

--
-- Name: service_conf_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.service_conf_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.service_conf_id_seq OWNER TO postgres;

--
-- Name: service_conf_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_conf_id_seq OWNED BY public.service_conf.id;


--
-- Name: service_history_conf; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service_history_conf (
    id integer NOT NULL,
    collection_timestamp timestamp without time zone,
    complaints integer,
    service_id integer
);


ALTER TABLE public.service_history_conf OWNER TO postgres;

--
-- Name: service_history_conf_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.service_history_conf_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.service_history_conf_id_seq OWNER TO postgres;

--
-- Name: service_history_conf_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_history_conf_id_seq OWNED BY public.service_history_conf.id;


--
-- Name: user_conf; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_conf (
    id integer NOT NULL,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    role_id integer
);


ALTER TABLE public.user_conf OWNER TO postgres;

--
-- Name: user_conf_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_conf_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_conf_id_seq OWNER TO postgres;

--
-- Name: user_conf_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_conf_id_seq OWNED BY public.user_conf.id;


--
-- Name: image_conf id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_conf ALTER COLUMN id SET DEFAULT nextval('public.image_conf_id_seq'::regclass);


--
-- Name: role_conf id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_conf ALTER COLUMN id SET DEFAULT nextval('public.role_conf_id_seq'::regclass);


--
-- Name: service_conf id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_conf ALTER COLUMN id SET DEFAULT nextval('public.service_conf_id_seq'::regclass);


--
-- Name: service_history_conf id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_history_conf ALTER COLUMN id SET DEFAULT nextval('public.service_history_conf_id_seq'::regclass);


--
-- Name: user_conf id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_conf ALTER COLUMN id SET DEFAULT nextval('public.user_conf_id_seq'::regclass);


--
-- Data for Name: image_conf; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.image_conf (id, file_name) FROM stdin;
1	instagram.png
2	youtube.png
3	facebook.png
4	outlook.png
5	gmail.png
6	github.png
7	zoom.png
8	googlemeet.png
9	snapchat.png
10	reddit.png
11	twitch.png
12	whatsapp.png
13	telegram.png
14	tiktok.png
15	spotify.png
\.


--
-- Data for Name: role_conf; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role_conf (id, name) FROM stdin;
1	Administrator
2	Operator
\.


--
-- Data for Name: service_conf; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.service_conf (id, name, query, image_id) FROM stdin;
1	Instagram	(#instagram OR instagram) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	1
2	Youtube	(#youtube OR youtube) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	2
3	Facebook	(#facebook OR facebook) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	3
4	Outlook	(#outlook OR outlook) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	4
5	Gmail	(#gmail OR gmail) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	5
6	GitHub	(#github OR github) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	6
7	Zoom	(#zoom OR zoom) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	7
8	Google Meet	(#googlemeet OR google meet) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	8
9	Snapchat	(#snapchat OR snapchat) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	9
10	Reddit	(#reddit OR reddit) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	10
11	Twitch	(#twitch OR twitch) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	11
12	Whatsapp	(#whatsapp OR whatsapp) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	12
13	Telegram	(#telegram OR telegram) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	13
14	TikTok	(#tiktok OR tiktok) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	14
15	Spotify	(#spotify OR spotify) (buffering OR glitching OR #isdown OR #iscrashing OR ("is crashing") OR ("not working")) -awesome -fine -good -great -happy -stock -amazing -lovely -is:retweet	15
\.


--
-- Data for Name: service_history_conf; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.service_history_conf (id, collection_timestamp, complaints, service_id) FROM stdin;
\.


--
-- Data for Name: user_conf; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_conf (id, password, username, role_id) FROM stdin;
1	$31$16$D2CuRF_kRFfJCstN0O5_pALj7dVfHcSlYqBza24vY8w	isdown_adm	1
\.


--
-- Name: image_conf_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.image_conf_id_seq', 30, true);


--
-- Name: role_conf_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_conf_id_seq', 6, true);


--
-- Name: service_conf_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.service_conf_id_seq', 30, true);


--
-- Name: service_history_conf_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.service_history_conf_id_seq', 1, false);


--
-- Name: user_conf_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_conf_id_seq', 3, true);


--
-- Name: image_conf image_conf_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_conf
    ADD CONSTRAINT image_conf_pkey PRIMARY KEY (id);


--
-- Name: role_conf role_conf_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_conf
    ADD CONSTRAINT role_conf_pkey PRIMARY KEY (id);


--
-- Name: service_conf service_conf_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_conf
    ADD CONSTRAINT service_conf_pkey PRIMARY KEY (id);


--
-- Name: service_history_conf service_history_conf_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_history_conf
    ADD CONSTRAINT service_history_conf_pkey PRIMARY KEY (id);


--
-- Name: service_conf uk_3hfjocp7tlupbmk38qvl3duml; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_conf
    ADD CONSTRAINT uk_3hfjocp7tlupbmk38qvl3duml UNIQUE (name);


--
-- Name: user_conf uk_4ticbs184en8soghxerhhek0k; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_conf
    ADD CONSTRAINT uk_4ticbs184en8soghxerhhek0k UNIQUE (username);


--
-- Name: role_conf uk_ig3ntqj2for2eave00wk46k5i; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_conf
    ADD CONSTRAINT uk_ig3ntqj2for2eave00wk46k5i UNIQUE (name);


--
-- Name: image_conf uk_tdtu4q34s1523vp5a4iq0dqs6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_conf
    ADD CONSTRAINT uk_tdtu4q34s1523vp5a4iq0dqs6 UNIQUE (file_name);


--
-- Name: user_conf user_conf_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_conf
    ADD CONSTRAINT user_conf_pkey PRIMARY KEY (id);


--
-- Name: service_conf fkeofcdxqieqrckjjdxye9rym7w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_conf
    ADD CONSTRAINT fkeofcdxqieqrckjjdxye9rym7w FOREIGN KEY (image_id) REFERENCES public.image_conf(id);


--
-- Name: user_conf fkjsf4hu0e96xcdnficrn4jbl2c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_conf
    ADD CONSTRAINT fkjsf4hu0e96xcdnficrn4jbl2c FOREIGN KEY (role_id) REFERENCES public.role_conf(id);


--
-- Name: service_history_conf fkqtigg7tse95mvs6st603863js; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_history_conf
    ADD CONSTRAINT fkqtigg7tse95mvs6st603863js FOREIGN KEY (service_id) REFERENCES public.service_conf(id);


--
-- PostgreSQL database dump complete
--