

INSERT INTO utilisateurs (nom, prenom, email, mdp, telephone, role)

VALUES
    ( 'Delafontaine', 'Jean', 'Jean@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65', 0 ),
    ( 'Dupont', 'Marc', 'dupont@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65', 0 ),
    ( 'John', 'poe', 'okaaay@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65', 1 ),
    ( 'Albert', 'Einstein', 'Albert@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65', 2 ),
    ( 'donald', 'trump', 'trump@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65', 2 ),
    ( 'claude', 'François', 'françois@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65', 1 ),
    ( 'quentin', 'tarantino', 'tarantino@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65', 2 ) ;

INSERT INTO outil (designation, fournisseur, marque,
                   modele, numero_de_serie, capacite, puissance, repere, etat, type_statut, periodicite, etalonnee)

VALUES

    ( 'Perceuse percussion filaire','','MAC ALLISTER' , 'MSHD600', '15W01 00171', '', '600W','PF007' ,'BON', 0 ,'',false),
    ( 'Perceuse percussion filaire', '','BOSH' , '', '3601A9C801', '', '800W', 'PF03' ,'BON', 0 ,'',false),
    ( 'perceuse angulaire', '','METABO' , 'WBE 700', '512001', '', '','PAF 01' ,'BON', 0 ,'',false),
    ( 'Scie circulaire à onglet', 'SOMEC','METABO' , 'KGS 254 M', '25400001027811100', '', '','S ONGLET F01' ,'MOYEN' , 0 ,'',false),



    ( 'PIED A COULISSE', 'BLANC','WILMART' , '', '15070122', '400mm', '','AC0001' ,'BON', 0 ,'12 mois',true),
    ( 'REGLET', 'ROZIER','' , '', '5552', '600mm', '', 'AC0005' ,'BON', 0 ,'12 mois',true),
    ( 'PIED A COULISSE', 'BLANC','WILMART' , '', '545451', '400mm', '','AC0008' ,'Non fonctionnel' , 1 ,'12 mois',true);






INSERT INTO entrees_sorties (id_outil,id_utilisateur, date_sortie, date_de_retour_prevue, date_retour, probleme, referencepv)

VALUES
    (1,1,'19971002','20030328','20030328', '', ''),(2,2,'19971002','20030328','20030328', '', ''),
    (3,3,'19971002','20030328','20030328', '', ''),(4,4,'19971002','20030328','20030328', '', ''),
    (5,5,'19971002','20030328','20030328', '', 'PV003'),(6,6,'19971002','20030328','20030328', '', 'PV0005'),
    (7,7,'19971002','20030328','20030328', 'Il est cassé', 'PV06')
