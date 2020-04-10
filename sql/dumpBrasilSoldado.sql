--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-03-10 22:07:09

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
-- TOC entry 215 (class 1259 OID 16908)
-- Name: battalion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.battalion (
    idbattalion integer NOT NULL,
    qttmembers integer NOT NULL,
    idpersonresponsible integer NOT NULL,
    fkcityid integer NOT NULL
);


ALTER TABLE public.battalion OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16906)
-- Name: battalion_idbattalion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.battalion_idbattalion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.battalion_idbattalion_seq OWNER TO postgres;

--
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 214
-- Name: battalion_idbattalion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.battalion_idbattalion_seq OWNED BY public.battalion.idbattalion;


--
-- TOC entry 211 (class 1259 OID 16882)
-- Name: city; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.city (
    idcity integer NOT NULL,
    name character varying(60) NOT NULL,
    initials character varying(3),
    fkstateid integer NOT NULL
);


ALTER TABLE public.city OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16880)
-- Name: city_idcity_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.city_idcity_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.city_idcity_seq OWNER TO postgres;

--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 210
-- Name: city_idcity_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.city_idcity_seq OWNED BY public.city.idcity;


--
-- TOC entry 205 (class 1259 OID 16855)
-- Name: interview; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.interview (
    idinterview integer NOT NULL,
    report text NOT NULL
);


ALTER TABLE public.interview OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16853)
-- Name: interview_idinterview_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.interview_idinterview_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.interview_idinterview_seq OWNER TO postgres;

--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 204
-- Name: interview_idinterview_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.interview_idinterview_seq OWNED BY public.interview.idinterview;


--
-- TOC entry 217 (class 1259 OID 16926)
-- Name: militaryJunta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."militaryJunta" (
    idmilitaryjunta integer NOT NULL,
    fkbattalionid integer NOT NULL
);


ALTER TABLE public."militaryJunta" OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16924)
-- Name: militaryJunta_idmilitaryjunta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."militaryJunta_idmilitaryjunta_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."militaryJunta_idmilitaryjunta_seq" OWNER TO postgres;

--
-- TOC entry 2949 (class 0 OID 0)
-- Dependencies: 216
-- Name: militaryJunta_idmilitaryjunta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."militaryJunta_idmilitaryjunta_seq" OWNED BY public."militaryJunta".idmilitaryjunta;


--
-- TOC entry 213 (class 1259 OID 16895)
-- Name: person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.person (
    idperson integer NOT NULL,
    name character varying(60) NOT NULL,
    surname character varying(60) NOT NULL,
    birthday date NOT NULL,
    cpf character varying(11) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(255) NOT NULL,
    type integer NOT NULL,
    enabled boolean NOT NULL,
    momsname character varying(120),
    dadsname character varying(120),
    fkcityid integer NOT NULL
);


ALTER TABLE public.person OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16957)
-- Name: personInterview; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."personInterview" (
    idpersoninterview integer NOT NULL,
    fkpersonid integer NOT NULL,
    fkinterviewid integer NOT NULL
);


ALTER TABLE public."personInterview" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16955)
-- Name: personInterview_idpersoninterview_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."personInterview_idpersoninterview_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."personInterview_idpersoninterview_seq" OWNER TO postgres;

--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 220
-- Name: personInterview_idpersoninterview_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."personInterview_idpersoninterview_seq" OWNED BY public."personInterview".idpersoninterview;


--
-- TOC entry 223 (class 1259 OID 16975)
-- Name: personQualification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."personQualification" (
    idpersonqualification integer NOT NULL,
    fkpersonid integer NOT NULL,
    fkqualificationid integer NOT NULL
);


ALTER TABLE public."personQualification" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16973)
-- Name: personQualification_idpersonqualification_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."personQualification_idpersonqualification_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."personQualification_idpersonqualification_seq" OWNER TO postgres;

--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 222
-- Name: personQualification_idpersonqualification_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."personQualification_idpersonqualification_seq" OWNED BY public."personQualification".idpersonqualification;


--
-- TOC entry 219 (class 1259 OID 16939)
-- Name: personWarning; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."personWarning" (
    idpersonwarning integer NOT NULL,
    fkpersonid integer NOT NULL,
    fkwarningid integer NOT NULL
);


ALTER TABLE public."personWarning" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16937)
-- Name: personWarning_idpersonwarning_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."personWarning_idpersonwarning_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."personWarning_idpersonwarning_seq" OWNER TO postgres;

--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 218
-- Name: personWarning_idpersonwarning_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."personWarning_idpersonwarning_seq" OWNED BY public."personWarning".idpersonwarning;


--
-- TOC entry 212 (class 1259 OID 16893)
-- Name: person_idperson_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.person_idperson_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.person_idperson_seq OWNER TO postgres;

--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 212
-- Name: person_idperson_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.person_idperson_seq OWNED BY public.person.idperson;


--
-- TOC entry 207 (class 1259 OID 16866)
-- Name: qualification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.qualification (
    idqualification integer NOT NULL,
    type character varying(45) NOT NULL,
    hasqualification boolean NOT NULL
);


ALTER TABLE public.qualification OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16864)
-- Name: qualification_idqualification_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.qualification_idqualification_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qualification_idqualification_seq OWNER TO postgres;

--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 206
-- Name: qualification_idqualification_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.qualification_idqualification_seq OWNED BY public.qualification.idqualification;


--
-- TOC entry 209 (class 1259 OID 16874)
-- Name: state; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.state (
    idstate integer NOT NULL,
    name character varying(45) NOT NULL,
    initials character varying(2) NOT NULL
);


ALTER TABLE public.state OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16872)
-- Name: state_idstate_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.state_idstate_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.state_idstate_seq OWNER TO postgres;

--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 208
-- Name: state_idstate_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.state_idstate_seq OWNED BY public.state.idstate;


--
-- TOC entry 203 (class 1259 OID 16844)
-- Name: warning; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.warning (
    idwarning integer NOT NULL,
    message text NOT NULL
);


ALTER TABLE public.warning OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16842)
-- Name: warning_idwarning_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.warning_idwarning_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.warning_idwarning_seq OWNER TO postgres;

--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 202
-- Name: warning_idwarning_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.warning_idwarning_seq OWNED BY public.warning.idwarning;


--
-- TOC entry 2755 (class 2604 OID 16911)
-- Name: battalion idbattalion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.battalion ALTER COLUMN idbattalion SET DEFAULT nextval('public.battalion_idbattalion_seq'::regclass);


--
-- TOC entry 2753 (class 2604 OID 16885)
-- Name: city idcity; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.city ALTER COLUMN idcity SET DEFAULT nextval('public.city_idcity_seq'::regclass);


--
-- TOC entry 2750 (class 2604 OID 16858)
-- Name: interview idinterview; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interview ALTER COLUMN idinterview SET DEFAULT nextval('public.interview_idinterview_seq'::regclass);


--
-- TOC entry 2756 (class 2604 OID 16929)
-- Name: militaryJunta idmilitaryjunta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."militaryJunta" ALTER COLUMN idmilitaryjunta SET DEFAULT nextval('public."militaryJunta_idmilitaryjunta_seq"'::regclass);


--
-- TOC entry 2754 (class 2604 OID 16898)
-- Name: person idperson; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person ALTER COLUMN idperson SET DEFAULT nextval('public.person_idperson_seq'::regclass);


--
-- TOC entry 2758 (class 2604 OID 16960)
-- Name: personInterview idpersoninterview; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personInterview" ALTER COLUMN idpersoninterview SET DEFAULT nextval('public."personInterview_idpersoninterview_seq"'::regclass);


--
-- TOC entry 2759 (class 2604 OID 16978)
-- Name: personQualification idpersonqualification; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personQualification" ALTER COLUMN idpersonqualification SET DEFAULT nextval('public."personQualification_idpersonqualification_seq"'::regclass);


--
-- TOC entry 2757 (class 2604 OID 16942)
-- Name: personWarning idpersonwarning; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personWarning" ALTER COLUMN idpersonwarning SET DEFAULT nextval('public."personWarning_idpersonwarning_seq"'::regclass);


--
-- TOC entry 2751 (class 2604 OID 16869)
-- Name: qualification idqualification; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qualification ALTER COLUMN idqualification SET DEFAULT nextval('public.qualification_idqualification_seq'::regclass);


--
-- TOC entry 2752 (class 2604 OID 16877)
-- Name: state idstate; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.state ALTER COLUMN idstate SET DEFAULT nextval('public.state_idstate_seq'::regclass);


--
-- TOC entry 2749 (class 2604 OID 16847)
-- Name: warning idwarning; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.warning ALTER COLUMN idwarning SET DEFAULT nextval('public.warning_idwarning_seq'::regclass);


--
-- TOC entry 2932 (class 0 OID 16908)
-- Dependencies: 215
-- Data for Name: battalion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.battalion (idbattalion, qttmembers, idpersonresponsible, fkcityid) FROM stdin;
\.


--
-- TOC entry 2928 (class 0 OID 16882)
-- Dependencies: 211
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.city (idcity, name, initials, fkstateid) FROM stdin;
\.


--
-- TOC entry 2922 (class 0 OID 16855)
-- Dependencies: 205
-- Data for Name: interview; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.interview (idinterview, report) FROM stdin;
\.


--
-- TOC entry 2934 (class 0 OID 16926)
-- Dependencies: 217
-- Data for Name: militaryJunta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."militaryJunta" (idmilitaryjunta, fkbattalionid) FROM stdin;
\.


--
-- TOC entry 2930 (class 0 OID 16895)
-- Dependencies: 213
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.person (idperson, name, surname, birthday, cpf, email, type, enabled, momsname, dadsname, fkcityid) FROM stdin;
\.


--
-- TOC entry 2938 (class 0 OID 16957)
-- Dependencies: 221
-- Data for Name: personInterview; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."personInterview" (idpersoninterview, fkpersonid, fkinterviewid) FROM stdin;
\.


--
-- TOC entry 2940 (class 0 OID 16975)
-- Dependencies: 223
-- Data for Name: personQualification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."personQualification" (idpersonqualification, fkpersonid, fkqualificationid) FROM stdin;
\.


--
-- TOC entry 2936 (class 0 OID 16939)
-- Dependencies: 219
-- Data for Name: personWarning; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."personWarning" (idpersonwarning, fkpersonid, fkwarningid) FROM stdin;
\.


--
-- TOC entry 2924 (class 0 OID 16866)
-- Dependencies: 207
-- Data for Name: qualification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.qualification (idqualification, type, hasqualification) FROM stdin;
\.


--
-- TOC entry 2926 (class 0 OID 16874)
-- Dependencies: 209
-- Data for Name: state; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.state (idstate, name, initials) FROM stdin;
\.


--
-- TOC entry 2920 (class 0 OID 16844)
-- Dependencies: 203
-- Data for Name: warning; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.warning (idwarning, message) FROM stdin;
\.


--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 214
-- Name: battalion_idbattalion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.battalion_idbattalion_seq', 1, false);


--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 210
-- Name: city_idcity_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.city_idcity_seq', 1, false);


--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 204
-- Name: interview_idinterview_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.interview_idinterview_seq', 1, false);


--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 216
-- Name: militaryJunta_idmilitaryjunta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."militaryJunta_idmilitaryjunta_seq"', 1, false);


--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 220
-- Name: personInterview_idpersoninterview_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."personInterview_idpersoninterview_seq"', 1, false);


--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 222
-- Name: personQualification_idpersonqualification_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."personQualification_idpersonqualification_seq"', 1, false);


--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 218
-- Name: personWarning_idpersonwarning_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."personWarning_idpersonwarning_seq"', 1, false);


--
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 212
-- Name: person_idperson_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.person_idperson_seq', 1, false);


--
-- TOC entry 2965 (class 0 OID 0)
-- Dependencies: 206
-- Name: qualification_idqualification_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.qualification_idqualification_seq', 1, false);


--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 208
-- Name: state_idstate_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.state_idstate_seq', 1, false);


--
-- TOC entry 2967 (class 0 OID 0)
-- Dependencies: 202
-- Name: warning_idwarning_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.warning_idwarning_seq', 1, false);


--
-- TOC entry 2773 (class 2606 OID 16913)
-- Name: battalion pk_battalion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.battalion
    ADD CONSTRAINT pk_battalion PRIMARY KEY (idbattalion);


--
-- TOC entry 2769 (class 2606 OID 16887)
-- Name: city pk_city; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.city
    ADD CONSTRAINT pk_city PRIMARY KEY (idcity);


--
-- TOC entry 2763 (class 2606 OID 16863)
-- Name: interview pk_interview; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interview
    ADD CONSTRAINT pk_interview PRIMARY KEY (idinterview);


--
-- TOC entry 2775 (class 2606 OID 16931)
-- Name: militaryJunta pk_militaryjunta; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."militaryJunta"
    ADD CONSTRAINT pk_militaryjunta PRIMARY KEY (idmilitaryjunta);


--
-- TOC entry 2771 (class 2606 OID 16900)
-- Name: person pk_person; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT pk_person PRIMARY KEY (idperson);


--
-- TOC entry 2779 (class 2606 OID 16962)
-- Name: personInterview pk_personinterview; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personInterview"
    ADD CONSTRAINT pk_personinterview PRIMARY KEY (idpersoninterview);


--
-- TOC entry 2781 (class 2606 OID 16980)
-- Name: personQualification pk_personqualification; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personQualification"
    ADD CONSTRAINT pk_personqualification PRIMARY KEY (idpersonqualification);


--
-- TOC entry 2777 (class 2606 OID 16944)
-- Name: personWarning pk_personwarning; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personWarning"
    ADD CONSTRAINT pk_personwarning PRIMARY KEY (idpersonwarning);


--
-- TOC entry 2765 (class 2606 OID 16871)
-- Name: qualification pk_qualification; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.qualification
    ADD CONSTRAINT pk_qualification PRIMARY KEY (idqualification);


--
-- TOC entry 2767 (class 2606 OID 16879)
-- Name: state pk_state; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.state
    ADD CONSTRAINT pk_state PRIMARY KEY (idstate);


--
-- TOC entry 2761 (class 2606 OID 16852)
-- Name: warning pk_warning; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.warning
    ADD CONSTRAINT pk_warning PRIMARY KEY (idwarning);


--
-- TOC entry 2786 (class 2606 OID 16932)
-- Name: militaryJunta fk_fkbattalionid_miliaryjunta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."militaryJunta"
    ADD CONSTRAINT fk_fkbattalionid_miliaryjunta FOREIGN KEY (idmilitaryjunta) REFERENCES public.battalion(idbattalion);


--
-- TOC entry 2785 (class 2606 OID 16919)
-- Name: battalion fk_fkcityid_battalion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.battalion
    ADD CONSTRAINT fk_fkcityid_battalion FOREIGN KEY (fkcityid) REFERENCES public.city(idcity);


--
-- TOC entry 2783 (class 2606 OID 16901)
-- Name: person fk_fkcityid_person; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT fk_fkcityid_person FOREIGN KEY (fkcityid) REFERENCES public.city(idcity);


--
-- TOC entry 2790 (class 2606 OID 16968)
-- Name: personInterview fk_fkinterviewid_personinterview; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personInterview"
    ADD CONSTRAINT fk_fkinterviewid_personinterview FOREIGN KEY (fkinterviewid) REFERENCES public.interview(idinterview);


--
-- TOC entry 2789 (class 2606 OID 16963)
-- Name: personInterview fk_fkpersonid_personinterview; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personInterview"
    ADD CONSTRAINT fk_fkpersonid_personinterview FOREIGN KEY (fkpersonid) REFERENCES public.person(idperson);


--
-- TOC entry 2791 (class 2606 OID 16981)
-- Name: personQualification fk_fkpersonid_personqualification; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personQualification"
    ADD CONSTRAINT fk_fkpersonid_personqualification FOREIGN KEY (fkpersonid) REFERENCES public.person(idperson);


--
-- TOC entry 2787 (class 2606 OID 16945)
-- Name: personWarning fk_fkpersonid_personwarning; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personWarning"
    ADD CONSTRAINT fk_fkpersonid_personwarning FOREIGN KEY (fkpersonid) REFERENCES public.person(idperson);


--
-- TOC entry 2792 (class 2606 OID 16986)
-- Name: personQualification fk_fkqualificationid_personqualification; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personQualification"
    ADD CONSTRAINT fk_fkqualificationid_personqualification FOREIGN KEY (fkqualificationid) REFERENCES public.qualification(idqualification);


--
-- TOC entry 2782 (class 2606 OID 16888)
-- Name: city fk_fkstateid_city; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.city
    ADD CONSTRAINT fk_fkstateid_city FOREIGN KEY (fkstateid) REFERENCES public.state(idstate);


--
-- TOC entry 2788 (class 2606 OID 16950)
-- Name: personWarning fk_fkwarningid_personwarning; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."personWarning"
    ADD CONSTRAINT fk_fkwarningid_personwarning FOREIGN KEY (fkwarningid) REFERENCES public.warning(idwarning);


--
-- TOC entry 2784 (class 2606 OID 16914)
-- Name: battalion fk_idpersonresponsible_battalion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.battalion
    ADD CONSTRAINT fk_idpersonresponsible_battalion FOREIGN KEY (idpersonresponsible) REFERENCES public.person(idperson);


-- Completed on 2020-03-10 22:07:10

--
-- PostgreSQL database dump complete
--

