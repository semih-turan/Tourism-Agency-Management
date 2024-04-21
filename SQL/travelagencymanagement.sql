PGDMP  $    3                |            travel2    16.2    16.2 +               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            !           1262    59710    travel2    DATABASE     �   CREATE DATABASE travel2 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE travel2;
                postgres    false            �            1255    59711 /   update_hotel_room_season_table_function_hotel()    FUNCTION       CREATE FUNCTION public.update_hotel_room_season_table_function_hotel() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    TRUNCATE hotel_room_season_table;
    INSERT INTO hotel_room_season_table
    SELECT h.*, r.*, s.*
    FROM hotel h
    INNER JOIN room r ON h.hotel_id = r.room_hotel_id
    INNER JOIN season s ON h.hotel_id = s.season_hotel_id;
    RETURN NULL;
END;
$$;
 F   DROP FUNCTION public.update_hotel_room_season_table_function_hotel();
       public          postgres    false            �            1255    59712 .   update_hotel_room_season_table_function_room()    FUNCTION     ~  CREATE FUNCTION public.update_hotel_room_season_table_function_room() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    TRUNCATE hotel_room_season_table;
    INSERT INTO hotel_room_season_table
    SELECT h.*, r.*, s.*
    FROM hotel h
    INNER JOIN room r ON h.hotel_id = r.room_hotel_id
    INNER JOIN season s ON h.hotel_id = s.season_hotel_id;
    RETURN NULL;
END;
$$;
 E   DROP FUNCTION public.update_hotel_room_season_table_function_room();
       public          postgres    false            �            1255    59713 0   update_hotel_room_season_table_function_season()    FUNCTION     �  CREATE FUNCTION public.update_hotel_room_season_table_function_season() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    TRUNCATE hotel_room_season_table;
    INSERT INTO hotel_room_season_table
    SELECT h.*, r.*, s.*
    FROM hotel h
    INNER JOIN room r ON h.hotel_id = r.room_hotel_id
    INNER JOIN season s ON h.hotel_id = s.season_hotel_id;
    RETURN NULL;
END;
$$;
 G   DROP FUNCTION public.update_hotel_room_season_table_function_season();
       public          postgres    false            �            1255    59714 $   update_pansion_type(integer, text[])    FUNCTION     L  CREATE FUNCTION public.update_pansion_type(hotel_id_arg integer, new_pansion_type_arr text[]) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN
    -- hotel_id'ye göre pansion tablosundaki ilgili girdileri güncelle
    UPDATE pansion
    SET pansion_type = new_pansion_type_arr
    WHERE pansion_hotel_id = hotel_id_arg;
END;
$$;
 ]   DROP FUNCTION public.update_pansion_type(hotel_id_arg integer, new_pansion_type_arr text[]);
       public          postgres    false            �            1259    59715    hotel    TABLE     L  CREATE TABLE public.hotel (
    hotel_id integer NOT NULL,
    hotel_name text NOT NULL,
    hotel_city text NOT NULL,
    hotel_region text NOT NULL,
    hotel_fulladress text NOT NULL,
    hotel_email text NOT NULL,
    hotel_phone text NOT NULL,
    hotel_star text NOT NULL,
    hotel_free_parking boolean NOT NULL,
    hotel_free_wifi boolean NOT NULL,
    hotel_swimming_pool boolean NOT NULL,
    hotel_fitness_center boolean NOT NULL,
    hotel_concierge boolean NOT NULL,
    hotel_spa boolean NOT NULL,
    hotel_room_services boolean NOT NULL,
    hotel_pansion_type text[]
);
    DROP TABLE public.hotel;
       public         heap    postgres    false            �            1259    59720    hotel_hotel_id_seq    SEQUENCE     �   ALTER TABLE public.hotel ALTER COLUMN hotel_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.hotel_hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    60635    hotel_room_season_table    TABLE     v  CREATE TABLE public.hotel_room_season_table (
    hotel_id integer,
    hotel_name text,
    hotel_city text,
    hotel_region text,
    hotel_fulladress text,
    hotel_email text,
    hotel_phone text,
    hotel_star text,
    hotel_free_parking boolean,
    hotel_free_wifi boolean,
    hotel_swimming_pool boolean,
    hotel_fitness_center boolean,
    hotel_concierge boolean,
    hotel_spa boolean,
    hotel_room_services boolean,
    hotel_pansion_type text[],
    room_id integer,
    room_hotel_id integer,
    room_season_id integer,
    room_type text,
    room_number text,
    room_capacity integer,
    room_adult_price integer,
    room_child_price integer,
    room_stock_quantity integer,
    room_bed_count integer,
    room_square_meters integer,
    room_has_tv boolean,
    room_has_mini_bar boolean,
    room_has_gaming_console boolean,
    room_has_safe_box boolean,
    room_has_projector boolean,
    room_pansion_type text,
    room_reservation_id integer,
    season_id integer,
    season_hotel_id integer,
    season_start_date date,
    season_end_date date,
    season_name text,
    season_hotel_name text
);
 +   DROP TABLE public.hotel_room_season_table;
       public         heap    postgres    false            �            1259    59726    pansion    TABLE     a   CREATE TABLE public.pansion (
    pansion_id integer NOT NULL,
    pansion_type text NOT NULL
);
    DROP TABLE public.pansion;
       public         heap    postgres    false            �            1259    59731    pansion_pansion_id_seq    SEQUENCE     �   ALTER TABLE public.pansion ALTER COLUMN pansion_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pansion_pansion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            �            1259    59732    reservation    TABLE     P  CREATE TABLE public.reservation (
    reservation_id integer NOT NULL,
    reservation_hotel_id integer NOT NULL,
    reservation_room_id integer NOT NULL,
    reservation_guest_fullname text NOT NULL,
    reservation_guest_id text NOT NULL,
    reservation_guest_mpno text NOT NULL,
    reservation_guest_email text NOT NULL,
    reservation_checkin_date date NOT NULL,
    reservation_checkout_date date NOT NULL,
    reservation_child_count integer NOT NULL,
    reservation_adult_count integer NOT NULL,
    reservation_total_price integer NOT NULL,
    reservation_date date NOT NULL
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            �            1259    59737    reservation_reservation_id_seq    SEQUENCE     �   ALTER TABLE public.reservation ALTER COLUMN reservation_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.reservation_reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    219            �            1259    59738    room    TABLE     �  CREATE TABLE public.room (
    room_id integer NOT NULL,
    room_hotel_id integer NOT NULL,
    room_season_id integer NOT NULL,
    room_type text NOT NULL,
    room_number text NOT NULL,
    room_capacity integer NOT NULL,
    room_adult_price integer NOT NULL,
    room_child_price integer NOT NULL,
    room_stock_quantity integer NOT NULL,
    room_bed_count integer NOT NULL,
    room_square_meters integer NOT NULL,
    room_has_tv boolean NOT NULL,
    room_has_mini_bar boolean NOT NULL,
    room_has_gaming_console boolean NOT NULL,
    room_has_safe_box boolean NOT NULL,
    room_has_projector boolean NOT NULL,
    room_pansion_type text NOT NULL,
    room_reservation_id integer
);
    DROP TABLE public.room;
       public         heap    postgres    false            �            1259    59743    room_room_id_seq    SEQUENCE     �   ALTER TABLE public.room ALTER COLUMN room_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.room_room_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    221            �            1259    59744    season    TABLE     �   CREATE TABLE public.season (
    season_id integer NOT NULL,
    season_hotel_id integer NOT NULL,
    season_start_date date NOT NULL,
    season_end_date date NOT NULL,
    season_name text NOT NULL,
    season_hotel_name text NOT NULL
);
    DROP TABLE public.season;
       public         heap    postgres    false            �            1259    59749    season_season_id_seq    SEQUENCE     �   ALTER TABLE public.season ALTER COLUMN season_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.season_season_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    223            �            1259    59750    users    TABLE     �   CREATE TABLE public.users (
    user_id bigint NOT NULL,
    user_name text NOT NULL,
    user_pass text NOT NULL,
    user_perm text NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    59755    user_user_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    225                      0    59715    hotel 
   TABLE DATA             COPY public.hotel (hotel_id, hotel_name, hotel_city, hotel_region, hotel_fulladress, hotel_email, hotel_phone, hotel_star, hotel_free_parking, hotel_free_wifi, hotel_swimming_pool, hotel_fitness_center, hotel_concierge, hotel_spa, hotel_room_services, hotel_pansion_type) FROM stdin;
    public          postgres    false    215   �D                 0    60635    hotel_room_season_table 
   TABLE DATA           �  COPY public.hotel_room_season_table (hotel_id, hotel_name, hotel_city, hotel_region, hotel_fulladress, hotel_email, hotel_phone, hotel_star, hotel_free_parking, hotel_free_wifi, hotel_swimming_pool, hotel_fitness_center, hotel_concierge, hotel_spa, hotel_room_services, hotel_pansion_type, room_id, room_hotel_id, room_season_id, room_type, room_number, room_capacity, room_adult_price, room_child_price, room_stock_quantity, room_bed_count, room_square_meters, room_has_tv, room_has_mini_bar, room_has_gaming_console, room_has_safe_box, room_has_projector, room_pansion_type, room_reservation_id, season_id, season_hotel_id, season_start_date, season_end_date, season_name, season_hotel_name) FROM stdin;
    public          postgres    false    227   �H                 0    59726    pansion 
   TABLE DATA           ;   COPY public.pansion (pansion_id, pansion_type) FROM stdin;
    public          postgres    false    217   YJ                 0    59732    reservation 
   TABLE DATA           U  COPY public.reservation (reservation_id, reservation_hotel_id, reservation_room_id, reservation_guest_fullname, reservation_guest_id, reservation_guest_mpno, reservation_guest_email, reservation_checkin_date, reservation_checkout_date, reservation_child_count, reservation_adult_count, reservation_total_price, reservation_date) FROM stdin;
    public          postgres    false    219   �J                 0    59738    room 
   TABLE DATA           R  COPY public.room (room_id, room_hotel_id, room_season_id, room_type, room_number, room_capacity, room_adult_price, room_child_price, room_stock_quantity, room_bed_count, room_square_meters, room_has_tv, room_has_mini_bar, room_has_gaming_console, room_has_safe_box, room_has_projector, room_pansion_type, room_reservation_id) FROM stdin;
    public          postgres    false    221   �J                 0    59744    season 
   TABLE DATA           �   COPY public.season (season_id, season_hotel_id, season_start_date, season_end_date, season_name, season_hotel_name) FROM stdin;
    public          postgres    false    223   tK                 0    59750    users 
   TABLE DATA           I   COPY public.users (user_id, user_name, user_pass, user_perm) FROM stdin;
    public          postgres    false    225   hL       "           0    0    hotel_hotel_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hotel_hotel_id_seq', 20, true);
          public          postgres    false    216            #           0    0    pansion_pansion_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.pansion_pansion_id_seq', 7, true);
          public          postgres    false    218            $           0    0    reservation_reservation_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.reservation_reservation_id_seq', 20, true);
          public          postgres    false    220            %           0    0    room_room_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.room_room_id_seq', 9, true);
          public          postgres    false    222            &           0    0    season_season_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.season_season_id_seq', 12, true);
          public          postgres    false    224            '           0    0    user_user_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.user_user_id_seq', 4, true);
          public          postgres    false    226            r           2606    59757    hotel hotel_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);
 :   ALTER TABLE ONLY public.hotel DROP CONSTRAINT hotel_pkey;
       public            postgres    false    215            t           2606    59759    pansion pansion_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pansion
    ADD CONSTRAINT pansion_pkey PRIMARY KEY (pansion_id);
 >   ALTER TABLE ONLY public.pansion DROP CONSTRAINT pansion_pkey;
       public            postgres    false    217            v           2606    59761    reservation reservation_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (reservation_guest_id, reservation_guest_mpno, reservation_guest_email);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    219    219    219            x           2606    59763    room room_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    221            z           2606    59765    season season_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_pkey PRIMARY KEY (season_id);
 <   ALTER TABLE ONLY public.season DROP CONSTRAINT season_pkey;
       public            postgres    false    223            |           2606    59767    users user_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 9   ALTER TABLE ONLY public.users DROP CONSTRAINT user_pkey;
       public            postgres    false    225            }           2620    59768 2   hotel update_hotel_room_season_table_trigger_hotel    TRIGGER     �   CREATE TRIGGER update_hotel_room_season_table_trigger_hotel AFTER INSERT OR DELETE OR UPDATE ON public.hotel FOR EACH STATEMENT EXECUTE FUNCTION public.update_hotel_room_season_table_function_hotel();
 K   DROP TRIGGER update_hotel_room_season_table_trigger_hotel ON public.hotel;
       public          postgres    false    228    215            ~           2620    59769 0   room update_hotel_room_season_table_trigger_room    TRIGGER     �   CREATE TRIGGER update_hotel_room_season_table_trigger_room AFTER INSERT OR DELETE OR UPDATE ON public.room FOR EACH STATEMENT EXECUTE FUNCTION public.update_hotel_room_season_table_function_room();
 I   DROP TRIGGER update_hotel_room_season_table_trigger_room ON public.room;
       public          postgres    false    221    229                       2620    59770 4   season update_hotel_room_season_table_trigger_season    TRIGGER     �   CREATE TRIGGER update_hotel_room_season_table_trigger_season AFTER INSERT OR DELETE OR UPDATE ON public.season FOR EACH STATEMENT EXECUTE FUNCTION public.update_hotel_room_season_table_function_season();
 M   DROP TRIGGER update_hotel_room_season_table_trigger_season ON public.season;
       public          postgres    false    230    223               �  x��VMo�8=O~��B��aɺ��v� N[��셑�M�$�T-��;�(�.Ѕ����x�ޛyt�4�5�R�	x�^�?J?�{�mè�')��\��ՌY��Q��w5�+y]��G�e�<*V��`Ϟo��VS�"���h?�W�/�P1*�=Ǿ��`S����a�Z��Yo4V���J�E#�$͢e^D�!�, �� Rص�0K����2d-�L0����!�|�Z��T��G��c�4[Fy���y��;<���;%j��"��˰��ܳ=�gY�#���b�?ċ!�t� K�Q��N��0ydz�/br:$Sԓq�q�F^
7���ѓ�k9ܪ�
�
Z��%k%�m��3��!'I�"�}Q�C�E� ��Y�&�@���5ù�.��JZ5�Y���� ��P�z�)�Y�gS���TӚvZ�r��/�s�2�y����j��(fsQ�%���}c�	Ŏ܌z�	3~ړ
�D蒦Q���Ɣ���pm����̆
k�)ಞ���������{�r�̥$�a��J�ֻ�[t�]WK���5X K��SΖJ?ƇL_�1 �D�9����KF.*�5w/�~eڽ�(M���v����$g�=��6�Vͣ�/�%�U+�}��� #\��S8�b�De��t�����'�/�sqtI�^Q7���8�r��D�����U��,J���F;�T��t�0��hd6
Q.�t��a�\��4���V���R=4�SO��ms:���@��fA��Y�)�����o�2�{�G��fM���Qw���dy\�<3��`��Ռlh7���	%i`\SR8��Eh�'�Q���q	W�noJW8gh����|h����q��&ij|��N����)Ip�K���y�[�{�պ��VC�
S'��&_d����닋��)Lx         �  x����K�0ǟ�E�U"��vۛu�
�9���-�bM�i���{�:�t��$�ܷ��}9�je���6��\��G[�@n��Y+� �LTiH��Z7P�'{��5Ͼ�la_�S�F�$����A�^��L��VdXUtlU�ʵ>� ���
8C� ��1<��M��B0σ�`"�,�l��e1�L��RFnZ�P"�v�
�R��Pض�F��uY�l�k��Cі]Ș&i�":�������=���(�����=���l��#��HB��262��Ьt��4��Iw~a�J�U��4��li�]�	M{}��d����%�t��{ǐ���w�Q#[-5���:�gʑ�R��ޭ�Z���*8��s~�z|���v>��Px��ӄ ��	\�&\O�� u4?�����         p   x�3��))JTp�����K�)-�,K�2�D�s:��($�(8�&f�%�p�p����(8�'�p�rz$�A9f�A���
�y9�\�H�\+��d��K��������� �})�            x������ � �         n   x�3�4�`O?wWNCC]CCNNNCS�p��ahNIQ��cN��g^rNiqfY*g��'b�d
2Ɉ$��9���d2ɜ����f�!�M������ ~�D�         �   x�}�Mj�0FףS�.���� m��`'���!R!K&����C�f�>��7�\�Y^g�s��cj���Z�w.�a�B�?��
_��c�?΄�j��+�HG��z
|o-+���
9�o����3�,_�*����m@my�ԅXuڦs~@�gZv�`��j�J^+���0�5��NPiOϊ��V�n�6:L����Iv��co�bxǉ}�0�~��v]         J   x�3�LL��̃��.��~\F���9������F�&���>����\Ɯ�%�ى�)�eP�&�I�%�h�b���� ��     